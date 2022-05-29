package codeofli.leetcode.binary_tree.traversal;


import codeofli.leetcode.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {



    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 迭代遍历，非递归版本
     * 栈模拟递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * Morris遍历实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        //当前结点cur，cur左子树上最右的节点，记为mostRight
        TreeNode cur = root, mostRight = null;
        while (cur != null) {
            if (cur.left == null) { //1.如果cur无左孩子，cur向右移动（cur=cur.right）
                res.add(cur.val);
                cur = cur.right;
            } else { //2.cur结点有左子树，找到左子树的最右结点mostRight。
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                //如果mostRight的right指针指向空，让其指向cur，cur向左移动
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                    //如果mostRight的right指针指向cur（说明已经遍历过一次cur结点）
                } else {
                    // 还原树结构
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    //LeetCode-Solution
    public List<Integer> preorderTraversalLeetCode(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }

}

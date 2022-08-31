package codeofli.leetcode.data_structure.tree.binary_tree.traversal;


import codeofli.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.*;

public class InorderTraversal {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    /**
     * 迭代版，栈模拟递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        // 栈 先进后出
        // 前序遍历，出栈顺序：根左右; 入栈顺序：右左根
        // 中序遍历，出栈顺序：左根右; 入栈顺序：右根左
        // 后序遍历，出栈顺序：左右根; 入栈顺序：根右左
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        // root为空且stack为空，遍历结束
        while (root != null || !stack.isEmpty()) {
            // 先根后左入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 此时root==null，说明上一步的root没有左子树
            // 1. 执行左出栈。因为此时root==null，导致root.right一定为null
            // 2. 执行下一次外层while代码块，根出栈。此时root.right可能存在
            // 3a. 若root.right存在，右入栈，再出栈
            // 3b. 若root.right不存在，重复步骤2
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }


    /**
     * Mirros遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root,mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            //是否有左子树
            if(mostRight != null){
                //找到最右结点
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                //是否访问过cur
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            //中序遍历
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }









    public static void main(String[] args) {

    }
}

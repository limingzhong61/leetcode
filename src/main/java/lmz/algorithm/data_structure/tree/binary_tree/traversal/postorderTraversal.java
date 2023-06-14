package lmz.algorithm.data_structure.tree.binary_tree.traversal;


import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class postorderTraversal {
    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;

    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * 迭代版本（栈模拟递归）
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode prev = null;
        //主要思想：
        //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
        //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，
        // 上一个访问过（已经递归访问结束）的节点是否为右子树
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //从栈中弹出的元素，左子树一定是访问完了的
            root = stack.pop();
            //现在需要确定的是:是否有右子树，或者右子树是否访问过
            //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            //说明可以访问当前节点
            if (root.right == null || prev == root.right) {
                res.add(root.val);
                //更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                prev = root;
                root = null; // 置为null标记：当前结点递归访问完成，
            } else {
                //如果右子树没有被访问，那么将当前节点压栈，访问右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 利用 Morris 遍历的方法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root,predecessor = null;

        while (cur != null){
            if(cur.left != null){ //左子树非空
                predecessor = cur.left;
                while(predecessor.right != null && predecessor.right != cur){
                    predecessor = predecessor.right;
                }
                if(predecessor == null) { // 没有访问完左子树,左移
                    predecessor.right = cur;
                    cur = cur.left;
                }else{ // 访问完左子树,右移，我们需要断开链接
                    res.add(cur.val);
                    predecessor.right = null; //还原树结构
                    cur = cur.right;
                }

            }else {// 如果没有左孩子，则直接访问右孩子
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}

package lmz.leetcode.data_structure.tree.binary_tree.bst;

import lmz.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TrimBST669 {
    /**
     * 递归
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val < low){
            return root.right;
        }else if(root.val > high){
            return root.left;
        }else{
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            return root;
        }
    }
    /**
     * 层次遍历记录相对顺序，然后再边删除边构造
     */
    public TreeNode trimBST1(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            nodeList.add(cur);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        root = null;
        for (TreeNode node : nodeList) {
            if (node.val >= low && node.val <= high) {
                node.left = node.right = null;
                root = insertBST(root, node);
            }
        }
        return root;
    }

    /**
     * 在二叉搜索树中插入一个结点 node
     * 注：在该二叉搜索树中不存在值相等的结点
     *
     * @param root
     * @param node
     * @return
     */
    private TreeNode insertBST(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        TreeNode cur = root;
        // 插入结点
        TreeNode pre = root;
        while (cur != null) {
            if (cur.val < node.val) {
                pre = cur;
                cur = cur.right;
            } else { // >
                pre = cur;
                cur = cur.left;
            }
        }
        if (node.val < pre.val) {
            pre.left = node;
        } else {
            pre.right = node;
        }
        return root;
    }


}

package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric28 {
    /**
     * 递归
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if(p == null || q == null ){
            return p == q;// 只有pq 都空才行
        }
        return p.val == q.val && dfs(p.left,q.right) && dfs(p.right,q.left);
    }


    /**
     * 迭代：遍历
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            //left-right
            leftQueue.add(leftNode.left);
            leftQueue.add(leftNode.right);
            //right-left
            rightQueue.add(leftNode.right);
            rightQueue.add(leftNode.left);
        }
        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }
}

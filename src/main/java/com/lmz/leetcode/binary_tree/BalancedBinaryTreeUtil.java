package com.lmz.leetcode.binary_tree;

import com.lmz.leetcode.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-06-07 11:59
 */
public class BalancedBinaryTreeUtil {
    /**
     * dfs:获取每个子树的高度，高度差不超过1为true
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // -1表示不平衡
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1; // 提前退出循环，结束递归
        int rightHeight = height(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

package com.lmz.algorithm.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-06-08 14:04
 */
public class DiameterOfBinaryTree543 {
    int ans = 0;

    /**
     * 每个节点的直径就是左右子树的高度之和。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return ans;
    }

    private int f(TreeNode root) {
        if (root == null) return 0;
        int left = f(root.left);
        int right = f(root.right);
        ans = Math.max(left + right, ans);
        return Math.max(left, right) + 1;
    }
}

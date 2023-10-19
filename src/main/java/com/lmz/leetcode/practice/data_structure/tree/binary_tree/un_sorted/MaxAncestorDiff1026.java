package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-04-18 13:52
 */
public class MaxAncestorDiff1026 {
    /**
     * 递归过程中记录最大最小值
     */
    public int maxAncestorDiff(TreeNode root) {
        return f(root, root.val, root.val);
    }

    private int f(TreeNode root, int min, int max) {
        if (root == null) return 0;
        int ans = Math.max(Math.abs(min - root.val), Math.abs(max - root.val));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        ans = Math.max(ans, f(root.left, min, max));
        ans = Math.max(ans, f(root.right, min, max));
        return ans;
    }

}

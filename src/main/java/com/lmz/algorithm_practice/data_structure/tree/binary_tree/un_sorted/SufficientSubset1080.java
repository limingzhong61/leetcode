package com.lmz.algorithm_practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-05-22 10:45
 */
public class SufficientSubset1080 {
    /**
     * 递归删除
     */
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return f(root, limit, 0);
    }

    private TreeNode f(TreeNode root, int limit, int sum) {
        if (root == null) return null;
        sum += root.val;
        boolean isLeaf = false;
        if (root.left == null && root.right == null) {
            if (sum < limit) return null;
            isLeaf = true;
        }
        root.left = f(root.left, limit, sum);
        root.right = f(root.right, limit, sum);
        if (!isLeaf && root.left == null && root.right == null)
            return null; // 不是叶子节点，但是左右子节点都被删除了
        return root;
    }

}

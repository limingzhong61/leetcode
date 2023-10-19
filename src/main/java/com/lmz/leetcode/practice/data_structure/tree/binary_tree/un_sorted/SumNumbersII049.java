package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-03-17 10:16
 */
public class SumNumbersII049 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        search(root, 0);
        return sum;
    }

    private void search(TreeNode root, int x) {
        if (root == null) {
            return;
        }
        x = x * 10 + root.val;
        // add left node
        if (root.left == null && root.right == null) {
            sum += x;
            return;
        }
        search(root.left, x);
        search(root.right, x);
    }
}

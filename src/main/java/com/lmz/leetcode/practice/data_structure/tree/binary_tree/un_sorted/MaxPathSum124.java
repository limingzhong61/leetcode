package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-06-11 19:38
 */
public class MaxPathSum124 {
    int maxSum = Integer.MIN_VALUE;
    /**
     * 递归计算子树的最大共享值
     * 当前节点的共享值为 left+ root.val +right
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

    /**
     * 递归计算子树的最大共享值
     * 当前节点的共享值为 left+ root.val +right
     * @param root
     * @return
     */
    public int maxPathSum2(TreeNode root) {
        dfs(root);
        return ans;
    }
    int ans = Integer.MIN_VALUE;
    private int  dfs(TreeNode root) {
        if(root == null) return 0 ;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans,left + right + root.val);
        return Math.max(0,Math.max(left,right) ) + root.val;
    }
}

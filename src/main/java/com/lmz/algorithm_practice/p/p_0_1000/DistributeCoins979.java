package com.lmz.algorithm_practice.p.p_0_1000;

import com.lmz.leetcode.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-07-14 10:41
 */
public class DistributeCoins979 {
    /**
     * lc题解：贡献法
     * 每条边贡献：x = |coins - nodes|
     * coins = c_l + c_r + val
     * nodes = n_l + n_r + 1
     * d_l = c_l - n_l
     * d_r = c_r - n_r
     * d = d_l + d_r +val - 1
     x = |d|
     */
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int d_l = dfs(root.left);
        int d_r = dfs(root.right);
        int d = d_l + d_r + root.val -1;
        ans += Math.abs(d);
        return d;
    }

}

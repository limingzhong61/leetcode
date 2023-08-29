package com.lmz.algorithm.other.n2000_3000;

import com.lmz.leetcode.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-08-20 10:20
 * @description:
 */
public class CheckTree2236 {
    public boolean checkTree(TreeNode root) {
        int sum = dfs(root);
        return sum == root.val;
    }

    int dfs(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        return dfs(root.left) + dfs(root.right);
    }
}

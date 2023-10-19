package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-03-17 10:08
 */
public class PruneTreeII047 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return  null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 叶子结点&val = 0
        if(root.left == null && root.right == null){
            if(root.val == 0){
                return null;
            }else{
                return root;
            }
        }
        return root;
    }
}

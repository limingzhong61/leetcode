package com.lmz.leetcode.practice.data_structure.tree.binary_tree.bst;


import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

public class SearchBST700 {
    /**
     * 迭代
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null){
            if(cur.val == val){
                return cur;
            }else if(cur.val < val){
                cur= cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }
}

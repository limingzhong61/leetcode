package com.lmz.leetcode.practice.data_structure.tree.binary_tree.bst;


import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

public class InsertIntoBST701 {
    /**
     * 所有值 Node.val 是 独一无二 的。
     * 保证 val 在原始BST中不存在。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root, lastNode = root;
        while(cur != null){
            lastNode = cur;
            if(cur.val < val){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        if(val < lastNode.val){
            lastNode.left = new TreeNode(val);
        }else {
            lastNode.right = new TreeNode(val);
        }
        return root;
    }
}

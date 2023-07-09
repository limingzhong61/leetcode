package com.lmz.algorithm.data_structure.tree.binary_tree.traversal;

import com.lmz.leetcode.binary_tree.po.TreeNode;

public class ConvertBSTII054 {
    /**
     * 二叉搜索树逆序遍历
     * 给定一个各节点值互不相同的二叉搜索树，更新每个节点的值为原二叉树上大于或者等于原当前节点值的所有原节点值之和。
     * 右中左遍历
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        root.right = convertBST(root.right);
        root.val  = sum += root.val;
        root.left = convertBST(root.left);
        return root;
    }
}

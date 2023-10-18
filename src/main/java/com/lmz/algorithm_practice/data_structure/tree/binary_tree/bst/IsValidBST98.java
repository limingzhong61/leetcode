package com.lmz.algorithm_practice.data_structure.tree.binary_tree.bst;


import com.lmz.leetcode.binary_tree.po.TreeNode;

public class IsValidBST98 {
    /**
     * 注意：结点应该在整棵树上符合bst规律
     * 思路： 利用中序遍历,二叉排序树有序
     */
    long preValue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;
        if (root.val <= preValue) return false;
        preValue = root.val;
        if (!isValidBST(root.right)) return false;
        return true;
    }


    /**
     * 前序遍历 ：递归传递节点范围
     * (low,high) 表示该节点应该符合的范围
     * 其左节点范围 (low,root.val),右节点范围 (root.val,high)
     * 注意： 边界，可以为Integer.MAX_VALUE;用long解决
     */
    public boolean isValidBST2(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long low, long high) {
        if (root == null)   return true;
        if (root.val >= high || root.val <= low) {
            return false;
        }
        return check(root.left, low, root.val) && check(root.right, root.val, high);
    }


}

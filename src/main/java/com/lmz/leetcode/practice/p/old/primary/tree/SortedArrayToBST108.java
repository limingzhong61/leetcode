package com.lmz.leetcode.practice.p.old.primary.tree;


import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

public class SortedArrayToBST108 {
    /**
     * 将有序数组转换为二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return bulidTree(nums,0,nums.length-1);
    }

    private TreeNode bulidTree(int[] nums, int left, int right) {
        if(left > right) return  null;
        // if(left == right) return  new TreeNode(nums[left]);
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bulidTree(nums,left,mid-1);
        node.right = bulidTree(nums,mid + 1,right);
        return node;
    }
}

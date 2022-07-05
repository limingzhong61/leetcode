package codeofli.leetcode.primary.tree;


import codeofli.leetcode.data_structure.binary_tree.TreeNode;

public class SortedArrayToBST108 {
    /**
     * my:递归版本
     * 思路：每次取[start,end]中间的数，然后递归至start ==end 结束
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }

    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) { //size == 0
            return null;
        }
        //1 <= nums.length <= 10^4
        int mid = (end + start) / 2;
        TreeNode left = buildBST(nums,start,mid-1);
        TreeNode right = buildBST(nums,mid+1,end);
        TreeNode root = new TreeNode(nums[mid], left,right);
        return  root;
    }
}

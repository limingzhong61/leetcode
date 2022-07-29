package codeofli.leetcode.find.binary_find;


import java.util.Arrays;

public class SearchRange34 {
    /**
     * 二分查找，然后左右寻找边界
     */
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index >= 0 && nums[index] == target) {
            int left = index, right = index;
            while (left >= 1 && nums[left - 1] == target) {
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right++;
            }
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }
}

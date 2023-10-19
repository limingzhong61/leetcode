package com.lmz.leetcode.practice.find.binary_search.not_unusual;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class FindPeakElement162 {

    /**
     *
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 1 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }else if (mid > 1 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;


    }

    /**
     * 二分查找峰值
     * 然后判断mid在哪一边：如果mid > 大的值，则一定在[peak,大]这边，则大值收缩，反之小值收缩
     * 峰值判断 [mid-1]<[mid]>[mid+1]
     * 注意特殊
     * [2,1]，0
     * [1],0
     */
    public int findPeakElement2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                if (mid > 0 && nums[mid] > nums[mid - 1]) { // peak judge
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FindPeakElement162 findPeakElement162 = new FindPeakElement162();
        System.out.println(findPeakElement162.findPeakElement(TransformUtil.toIntArray("[1,2,3,4,3,2]")));
    }
}

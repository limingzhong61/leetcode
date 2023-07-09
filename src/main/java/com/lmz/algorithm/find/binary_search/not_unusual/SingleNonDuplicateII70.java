package com.lmz.algorithm.find.binary_search.not_unusual;

/**
 * @author: limingzhong
 * @create: 2023-03-23 16:20
 */
public class SingleNonDuplicateII70 {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1 && mid < nums.length && nums[mid] == nums[mid + 1] ||
                    mid >=1 && nums[mid] == nums[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            System.out.printf("%d,%d,%d\n", low, high, mid);
        }
        return low;
    }
}

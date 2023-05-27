package lmz.algorithm.find.binary_search.not_unusual;

import lmz.my.leetcode.TransformUtil;

public class Search33 {
    /**
     * 二分查找
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) { //注意是<=
                if (nums[0] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search33 search33 = new Search33();
        testCase(search33, "[4,5,6,7,0,1,2]", 0, 4);
        testCase(search33, "[4,5,6,7,0,1,2]", 3, -1);
        testCase(search33, "[1]", 0, -1);
        testCase(search33, "[3,1]", 1, 1);
    }

    private static void testCase(Search33 search33, String original, int target, int x) {
        System.out.println(search33.search(TransformUtil.toIntArray(original), target));
        System.out.println(search33.search(TransformUtil.toIntArray(original), target) == x);
    }
}

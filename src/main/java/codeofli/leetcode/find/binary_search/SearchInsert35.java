package codeofli.leetcode.find.binary_search;

public class SearchInsert35 {
    /**
     * my二分查找：返回小于target的个数
     * [<target](目标index)[>=target]
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

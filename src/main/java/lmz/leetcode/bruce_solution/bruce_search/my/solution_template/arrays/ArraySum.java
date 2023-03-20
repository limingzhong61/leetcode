package lmz.leetcode.bruce_solution.bruce_search.my.solution_template.arrays;
/**
 * 前缀和
 */
public class ArraySum {
    int[] nums;
    // sums[i] = nums[0,i-1]
    int[] sums;

    public ArraySum(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) {
            return;
        }
        this.sums = new int[nums.length + 1];
        sums[1] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    /**
     * 前缀和
     */
    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}

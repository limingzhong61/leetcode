package lmz.leetcode.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-10-31 23:21
 */
public class RunningSum1480 {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

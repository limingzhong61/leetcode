package codeofli.leetcode.other.medium;

/**
 * @author: codeofli
 * @create: 2022-10-25 16:52
 */
public class WaysToSplit1712 {
    /**
     * @param nums
     * @return
     */
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i < n; i++){
            sum[i] = nums[i - 1] + sum[i-1];
        }

    }
}

package codeofli.leetcode.contest.c312;

import java.util.stream.IntStream;

public class LongestSubarray {
    /**
     * x | y <= (x or y)
     */
    public int longestSubarray(int[] nums) {
        int max = IntStream.of(nums).max().getAsInt();
        int n = nums.length;
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                int j = i;
                while (j + 1 < n && nums[j + 1] == max) {
                    j++;
                }
                res = Math.max(j - i + 1,res);
                i = j;
            }
        }
        return res;
    }
}

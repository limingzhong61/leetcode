package codeofli.leetcode.other.easy;

import java.util.Arrays;

public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        Arrays.sort(nums);
        double res = 0;
        int n = nums.length;
        for(int i = 0; i < k; i++){
            res += nums[n - 1 - k];
        }
        double sum = 0;
        for(int i = 0; i < n - k - 1; i++){
            sum += nums[i];
        }
        return res + sum /(n-k-1);
    }
}

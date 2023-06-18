package lmz.algorithm.contest.c350;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-06-18 10:36
 */
public class FindValueOfPartition {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            ans = Math.min(ans,nums[i] -  nums[i-1]);
        }
        return ans;
    }
}

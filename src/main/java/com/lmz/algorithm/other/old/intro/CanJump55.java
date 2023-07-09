package com.lmz.algorithm.other.old.intro;

import com.lmz.my.leetcode.TransformUtil;

public class CanJump55 {
    /**
     * dp表示前i个元素所能到达的最远位置
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1)return true;
        if (nums[0] == 0)return false;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++)
        {
            if (dp[i-1] >= nums.length - 1)return true;
            if (i <= dp[i - 1])dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return false;
    }

    /**
     * leetcode贪心：维护一个最远可以到达的位置
     * 我们依次遍历数组中的每一个位置，并实时维护 最远可以到达的位置。对于当前遍历到的位置 x，如果它在
     * 最远可以到达的位置 的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用
     * x+nums[x] 更新 最远可以到达的位置。
     *
     * 在遍历的过程中，如果 最远可以到达的位置 大于等于数组中的最后一个位置，
     * 那就说明最后一个位置可达，我们就可以直接返回 True 作为答案。
     * 反之，如果在遍历结束后，最后一个位置仍然不可达，我们就返回 False 作为答案。
     */
    public boolean canJump2(int[] nums) {
        int maxIndex = 0;
        int n = nums.length -1;
        for(int i = 0; i <= n; i++){
            if(i <= maxIndex){
                maxIndex = Math.max(maxIndex,i+nums[i]);
                if(maxIndex >= n){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * f[i] 能否到达,记忆化搜索
     * f[i] == 1 能到达，-1不能到达
     */
    int[] f;
    int[] nums;

    public boolean canJump1(int[] nums) {
        f = new int[nums.length];
        this.nums = nums;
        f[0] = 1;
       return  dfs(nums.length - 1) == 1;
    }

    private int dfs(int x) {
        if (f[x] != 0) {
            return f[x];
        }
        for (int i = x-1; i >= 0; i--) {
            if (i + nums[i] >= x && dfs(i) == 1) {
                return f[x] = 1;
            }
        }
        return f[x] =  -1;
    }

    public static void main(String[] args) {
        CanJump55 canJump55 = new CanJump55();
        System.out.println(canJump55.canJump(TransformUtil.toIntArray("[2,3,1,1,4]")));
        System.out.println(canJump55.canJump(TransformUtil.toIntArray("[3,2,1,0,4]")));
        System.out.println(canJump55.canJump(TransformUtil.toIntArray("[2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0," +
                "7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6]")));
    }
}

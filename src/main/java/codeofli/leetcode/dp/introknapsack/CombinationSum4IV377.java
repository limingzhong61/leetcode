package codeofli.leetcode.dp.introknapsack;

public class CombinationSum4IV377 {
    /**
     * 无穷背包问题
     * f[i]表示构成i的数目有多少种，f[0]=1;
     * 1 <= target <= 1000
     */
    public int combinationSum4(int[] nums, int target) {
        //1 <= nums.length <= 200
        int[] f = new int[target+1];
        f[0] = 1;
        for(int i = 1; i <= target; i++){
            for (int num : nums) {
                if (i - num >= 0) {
                    f[i] += f[i - num];
                }
            }
        }
        return  f[target];
    }
}

package com.lmz.leetcode.practice.contest.c331;

/**
 * @author: limingzhong
 * @create: 2023-02-05 10:58
 */
public class MinCapability {
    /**
     * 二分
     */
    public int minCapability(int[] nums, int k) {

        //1 <= nums[i] <= 109
        int low = 1, high = (int) (1e9);
        // false,false,...false,true; low
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean check(int[] nums, int k, int x) {
        int n = nums.length;
        var f = new int[n][2];
        if (nums[0] <= x) {
            f[0][1] = 1;
        }
        for (int i = 1; i < n; i ++) {
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
            if (nums[i] <= x) { // 取
                f[i][1] = f[i - 1][0] + 1;
            }
        }
        return f[n - 1][0] >= k || f[n - 1][1] >= k;
    }
    ///**
    // * dp
    // * 1 <= nums.length <= 105
    // */
    //public int minCapability(int[] nums, int k) {
    //    int n = nums.length;
    //    //i,j,k,[0,i]吃了j次的最小值，k表示i处吃没吃
    //    var f = new int[n][k+1][2];
    //    final int max = Integer.MIN_VALUE;
    //    PriorityQueue<>
    //    for(int i = 0; i < n; i++){
    //        if(i == 0){
    //            f[i][0][0] = max;
    //            f[i][1][1] = nums[i];
    //            continue;
    //        }
    //        if(i== 1){
    //            f[i][0][0] = max;
    //            f[i][1][1] = Math.min(nums[i],nums[i-1]);
    //            continue;
    //        }
    //        f[i][0][0] = max;
    //        for(int j = 1; j <= k; j++){
    //            f[i][j][0] = Math.;
    //            f[i][j][1] = Math.max(f[i-2][j-1][1],nums[i]);
    //        }
    //    }
    //    int res= Integer.MAX_VALUE;
    //    for(int i = 0; i < n; i++){
    //        res = Math.min(f[i][k][1],res);
    //    }
    //    return res;
    //}
}

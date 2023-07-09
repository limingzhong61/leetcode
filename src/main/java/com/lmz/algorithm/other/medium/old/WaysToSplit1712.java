package com.lmz.algorithm.other.medium.old;

import com.lmz.my.leetcode.TransformUtil;

/**
 * @author: codeofli
 * @create: 2022-10-25 16:52
 */
public class WaysToSplit1712 {



    /**
     * lc 两对双指针
     * k,j对于i都是单调递增的
     */
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        //3 <= nums.length <= 10^5
        int i = 1, j = 2,k = 2;
        long res = 0;
        final int MOD = (int) 1e9 + 7;
        // i 的取值范围[0,n-2]
        while (i   < n - 1 && sum[i] * 3 <= sum[n]) {
            int s1 = sum[i];
            // 两个分割点必须保持前后顺序
            j = Math.max(i + 1, j);
            while (j < n - 1 && sum[j] - sum[i] < s1) {
                j++;
            }
            while (k < n - 1 && sum[n] - sum[k +1] >= sum[k + 1] - sum[i]) {
                k++;
            }
            res = (res  + k - j + 1)% MOD;
            i++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        WaysToSplit1712 waysToSplit1712 = new WaysToSplit1712();
        System.out.println(waysToSplit1712.waysToSplit(TransformUtil.toIntArray("[1,2,2,2,5,0]")));
        System.out.println(waysToSplit1712.waysToSplit(TransformUtil.toIntArray("[1,2,2,2,5,0]")) == 3);
    }
}

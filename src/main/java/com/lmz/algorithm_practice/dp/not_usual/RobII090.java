package com.lmz.algorithm_practice.dp.not_usual;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-03-31 10:27
 */
public class RobII090 {
    //    其实就是把环拆成两个队列，一个是从0到n-1，另一个是从1到n，然后返回两个结果最大的。
    public int rob(int[] nums) {
        int n = nums.length;
        // 1 <= nums.length <= 100
        if(n == 1){
            return nums[0];
        }

        // 0~n-1
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        int max1 = f[1];
        for (int i = 2; i < n-1; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
            max1 = Math.max(f[i],max1);
        }
        Arrays.fill(f,0);
        f[1] = nums[1];
        f[2] = Math.max(nums[1], nums[2]);
        int max2 = f[2];
        for (int i = 3; i < n; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
            max2 = Math.max(f[i],max2);
        }
        return Math.max(max2,max1);
    }
}

package com.lmz.leetcode.practice.simulation;

import java.util.Arrays;

/**
 * @author: codeofli
 * @create: 2022-10-25 14:50
 */
public class FindLatestStep1562 {
    /**
     * 在每种情况下，我们都会修改数组 $\textit{endpoints}$。
     * **不过对于一个新生成的分组，我们无需修改其中每个位置的取值：只需修改该分组左右端点处的取值即可**。
     * 这是因为，在进行每一步操作时，都**不会在一个已有的分组内部做修改，只会考虑已有分组的端点处的取值**。
     */
    public int findLatestStep(int[] arr, int m) {
        //1 <= n <= 10^5
        int n = arr.length;
        // 二进制字符串和 arr 都是从 1 开始索引的情况下
        var endpoints = new int[n + 1][2];
        for (int[] endpoint : endpoints) {
            Arrays.fill(endpoint, -1);
        }
        int res = -1,step = 0,mCnt = 0;
        for (int i : arr) {
            step++;
            int left = i, right = i;
            if (i > 1 && endpoints[i - 1][1] != -1) {
                left = endpoints[i - 1][0];
                if(endpoints[i-1][1] - endpoints[i-1][0]  + 1 == m){
                    mCnt--;
                }
            }
            if (i < n && endpoints[i + 1][0] != -1) {
                right = endpoints[i + 1][1];
                if(endpoints[i+1][1] - endpoints[i+1][0]  + 1 == m){
                    mCnt--;
                }
            }
            endpoints[left][0] =  endpoints[right][0] = left;
            endpoints[left][1] =  endpoints[right][1] = right;
            // 返回存在长度 恰好 为 m 的 一组 1  的最后步骤。
            if(right - left + 1 == m){
                mCnt++;
            }
            if(mCnt > 0){
                res = step;
            }
        }
        return res;
    }
}

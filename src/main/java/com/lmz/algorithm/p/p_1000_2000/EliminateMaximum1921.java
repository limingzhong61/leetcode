package com.lmz.algorithm.p.p_1000_2000;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-09-03 9:37
 */
public class EliminateMaximum1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        // 计算到达所需时间
        int n = dist.length;
        // time[i] 表示 到达的时间
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            int t = dist[i] / speed[i];
            // 不能整除，多加一段时间
            if (dist[i] % speed[i] != 0) {
                t++;
            }
            time[i] = t;
        }
        Arrays.sort(time);
        for (int i = 0; i < n; i++) {
            // i时刻怪兽已经到达
            if(i >= time[i]){
                return i;
            }
        }
        return n;
    }
}

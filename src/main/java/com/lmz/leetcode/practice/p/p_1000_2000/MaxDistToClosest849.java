package com.lmz.leetcode.practice.p.p_1000_2000;

/**
 * @author: limingzhong
 * @create: 2023-08-22 10:31
 * @description:
 */
public class MaxDistToClosest849 {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length,startIdx = -1;
        int maxDis = 0;

        for(int i = 0; i < len; i++){
            if(seats[i] == 1){
                startIdx = i;
                // 边界到第一个1的距离，中间0的个数
                int half = i;
                if(maxDis < half){
                    maxDis = half;
                }
                break;
            }
        }
        for(int i = startIdx; i < len; i++){
            if(seats[i] == 1){
                // 中间0的个数
                int dis = i - startIdx - 1;
                int half = (dis + 1) / 2;
                if(maxDis < half){
                    maxDis = half;
                }
                startIdx = i;
            }
        }
        // 边界到前一个1的距离，中间0的个数
        int half = len - startIdx - 1;
        if(maxDis < half){
            maxDis = half;
        }
        return maxDis;
    }
}

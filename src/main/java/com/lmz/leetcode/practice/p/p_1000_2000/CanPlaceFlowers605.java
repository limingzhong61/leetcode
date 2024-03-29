package com.lmz.leetcode.practice.p.p_1000_2000;

/**
 * @author: limingzhong
 * @create: 2023-08-04 14:38
 */
public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < n; i++){
            if(flowerbed[i] != 1 &&(i < 1 || flowerbed[i-1] != 1) && (i > n - 1 || flowerbed[i+1] != 1)){
                flowerbed[i] = 1;
                n--;
            }
        }
        return  n <= 0;
    }
}

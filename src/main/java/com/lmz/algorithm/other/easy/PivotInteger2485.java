package com.lmz.algorithm.other.easy;

/**
 * @author: limingzhong
 * @create: 2023-06-26 13:04
 */
public class PivotInteger2485 {
    public int pivotInteger(int n) {
        int left = 0,right = n *(n+1) /2;
        for(int i = 1; i <= n; i++){
            left += i;
            right -= i - 1;
            if(left == right ){
                return i;
            }
        }
        return -1;
    }
}

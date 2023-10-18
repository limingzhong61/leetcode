package com.lmz.algorithm_practice.other.old.hard;

import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-01-14 19:35
 */
public class CountDifferentSubsequenceGCDs1819 {
    /**
     * 枚举+gcd
     */
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = IntStream.of(nums).max().getAsInt();
        boolean[] occured = new boolean[max + 1];
        for (int num : nums) {
            occured[num] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= max; i++) {
            // 0 和任何数 x 的最大公约数都是 x
            int subGcd = 0;
            for (int j = i; j <= max; j += i) {
                if(occured[j]){
                    if(subGcd == 0){
                        subGcd = j;
                    }else{
                        subGcd = gcd(subGcd, j);
                    }
                    if(subGcd == i){
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

package com.lmz.algorithm.other.easy.old;

public class MinOperations1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] cs = boxes.toCharArray();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < i; j++){
                if(cs[j] == '1'){
                    sum += i - j;
                }
            }
            for(int j = i + 1; j < n; j++){
                if(cs[j] == '1'){
                    sum += j - i;
                }
            }
            res[i] = sum;
        }
        return res;
    }
}

package com.lmz.leetcode.practice.contest.c333;

public class MinOperations {
    /**
     *
     */
    public int minOperations(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return  1;
        }
        int x = 2,lastX = 2;
        while (x< n) {
            lastX = x;
            x *= 2;
        }
        int left = n - lastX, right = x - n;

        return  Math.min(1+ minOperations(left),1 +minOperations(right));
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(39));
        System.out.println(minOperations.minOperations(54));
    }
}

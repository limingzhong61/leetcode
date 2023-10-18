package com.lmz.algorithm_practice.other.old.search_and_recur;

public class SumNums64 {
    /**
     * 求 1+2+...+n ，
     * 要求不能使用乘除法、for、while、if、else、switch、case等
     * 关键字及条件判断语句（test.A?B:C）。
     */
    /**
     * leetcode:利用逻辑运算符的短路性质
     */
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
    /**
     * 3元也是判断
     */
    public int sumNums1(int n) {
        return n == 1? 1 : sumNums1(n-1) + n;
    }
}

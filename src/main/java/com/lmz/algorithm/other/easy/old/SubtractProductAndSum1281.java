package com.lmz.algorithm.other.easy.old;

public class SubtractProductAndSum1281 {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mult = 1;
        //获取每一位的数字
        //获取数字位数，用do-while,防止0的情况
        do {
            sum += n % 10;
            mult *= n % 10;
            n /= 10;
        } while (n != 0);
        return mult - sum;
    }
}

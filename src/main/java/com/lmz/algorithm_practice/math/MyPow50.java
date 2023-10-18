package com.lmz.algorithm_practice.math;

public class MyPow50 {
    /**
     * 使用java api
     */
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }
    /**
     * 注意有负数
     */
    public double myPow1(double x, int n) {
        if(n == 0){
            return 1;
        }
        return n >0 ?  quickPow(x,n) : 1 / quickPow(x,-n);
    }

    /**
     * @param n > 0
     */
    private double quickPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        double y = n % 2 == 1 ? x : 1;
        return y * quickPow(x, n / 2) * quickPow(x, n / 2);
    }

    public static void main(String[] args) {
        MyPow50 myPow50 = new MyPow50();
        System.out.println(myPow50.quickPow(0.00001, 2147483647));
    }
}

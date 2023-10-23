package com.lmz.leetcode.practice.p.old.math;

public class CuttingRope14I {
    public int cuttingRope(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }

        return sum * n;
    }

    public static void main(String[] args) {
        CuttingRope14I cuttingRope14I = new CuttingRope14I();

        System.out.println(cuttingRope14I.cuttingRope(2));
        System.out.println(cuttingRope14I.cuttingRope(2) == 1);

        System.out.println(cuttingRope14I.cuttingRope(10));
        System.out.println(cuttingRope14I.cuttingRope(10) == 36);

        System.out.println(cuttingRope14I.cuttingRope(5));
        System.out.println(cuttingRope14I.cuttingRope(5) == 6);

        System.out.println(cuttingRope14I.cuttingRope(6));
        System.out.println(cuttingRope14I.cuttingRope(6) == 9);

        System.out.println(cuttingRope14I.cuttingRope(7));
        System.out.println(cuttingRope14I.cuttingRope(7) == 12);
    }
}

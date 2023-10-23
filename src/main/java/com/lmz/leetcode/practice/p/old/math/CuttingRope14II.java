package com.lmz.leetcode.practice.p.old.math;

public class CuttingRope14II {
    public int cuttingRope(int n) {
        if (n <= 3)
            return n-1;
        int mod = 1000000007;
        long res = 1;
        //贪心算法，优先切三，其次切二
        while (n > 4) {
            res = res  * 3 % mod;
            n -= 3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res * n % mod);
    }

    public static void main(String[] args) {
        CuttingRope14II cuttingRope14I = new CuttingRope14II();

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

        System.out.println(cuttingRope14I.cuttingRope(120));
        System.out.println(cuttingRope14I.cuttingRope(120) == 953271190);

        System.out.println(cuttingRope14I.cuttingRope(127));
        System.out.println(cuttingRope14I.cuttingRope(127) == 439254203);
    }
}

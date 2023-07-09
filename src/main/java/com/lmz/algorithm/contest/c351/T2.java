package com.lmz.algorithm.contest.c351;


/**
 * @author: limingzhong
 * @create: 2023-06-25 10:29
 */
public class T2 {
    public int makeTheIntegerZero(int num1, int num2) {
        int n = (int) 1e7;
        for(long i = 0; i <= n; i++){
            if (check(num1, num2, i)) {
                return (int) i;
            }
        }
        return -1;
    }

    private boolean check(long nums1, long num2, long time) {
        long x = nums1 - time * num2;
        if(x <= 0) return  false;
        int cnt = 0;
        for (long i = 0; i <= 63; i++) {
            if ((x & (1L << i)) != 0) {
                cnt++;
            }
        }
        return cnt <= time;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        testCase(t2, 16,-11, 3);
        testCase(t2, 52, -12, 1);
        testCase(t2, 5, -21, 3);
    }

    private static void testCase(T2 t2, int num1, int x, int x1) {
        System.out.println(t2.makeTheIntegerZero(num1,x));
        System.out.println(t2.makeTheIntegerZero(num1,x) == x1);
    }
}

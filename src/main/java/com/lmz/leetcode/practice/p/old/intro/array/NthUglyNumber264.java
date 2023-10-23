package com.lmz.leetcode.practice.p.old.intro.array;

public class NthUglyNumber264 {
    /**
     * 1 <= n <= 1690
     * 因为n的范围很小，故枚举全部可行
     */
    public int nthUglyNumber(int n) {
        int len = 1691;
        boolean[] ugly = new boolean[1691];
        ugly[1] = true;
        for(int i = 2; i < len; i += 2){
            ugly[i] = true;
        }
        for(int i = 3; i < len; i += 3){
            ugly[i] = true;
        }
        for(int i = 5; i < len; i += 5){
            ugly[i] = true;
        }
        int cnt = 0;
        for(int i = 1; i < len; i++){
            if(ugly[i]){
                cnt++;
                if(cnt == n){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NthUglyNumber264 nthUglyNumber = new NthUglyNumber264();
        System.out.println(nthUglyNumber.nthUglyNumber(10));
        System.out.println(nthUglyNumber.nthUglyNumber(10) == 12);
        System.out.println(nthUglyNumber.nthUglyNumber(1));
        System.out.println(nthUglyNumber.nthUglyNumber(1) == 1);
        System.out.println(nthUglyNumber.nthUglyNumber(1690));
        System.out.println(nthUglyNumber.nthUglyNumber(1690) == 12);

    }
}

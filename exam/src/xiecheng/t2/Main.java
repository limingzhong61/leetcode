package xiecheng.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {

    //static long gcd(long y, long x) {
    //    return x == 0 ? y : gcd(x, y % x);
    //}
    static long gcd(long y, long x) {
        while(x != 0){
            long temp = y % x;
            y = x;
            x = temp;
        }
        return y;
    }

    public static void main(String args[]) {
        //System.out.prlongln(longeger.MAX_VALUE);
        //System.out.prlongln(Long.MAX_VALUE);
        Scanner cin = new Scanner(System.in);
        long t;
        while (cin.hasNextLong()) {
            t = cin.nextLong();

            for (long i = 0; i < t; i++) {
                long n = cin.nextLong();
                long x = n / 2;
                for (; ; ) {
                    long y = n - x;
                    long g = gcd(y, x);
                    if (g == 1) {
                        System.out.printf("%d %d\n",x,y);
                        break;
                    }
                    x--;
                }
            }
        }

    }


}
























package meituan.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m, n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            m = cin.nextInt();
            double res = n, x = n;
            for (int i = 1; i < m; i++) {
                x = Math.sqrt(x);
                res += x;
                //System.out.println(res);
            }
            System.out.printf("%.2f\n",res);
            //System.out.println("------------");
        }
    }
}

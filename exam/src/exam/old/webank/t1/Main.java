package exam.old.webank.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int l, r, x, y;
        int t = cin.nextInt();
        for (int a = 0; a < t; a++) {
            l = cin.nextInt();
            r = cin.nextInt();
            x = cin.nextInt();
            y = cin.nextInt();
            //
            int res = 0;
            for (int i = x; i <= y; i++) {
                if ((i & x) != x || (i | y) != y) continue;

                int cntOne = Integer.bitCount(i);
                if (cntOne >= l && cntOne <= r) {
                    res++;
                }
            }
            System.out.println(res);
        }

    }
}























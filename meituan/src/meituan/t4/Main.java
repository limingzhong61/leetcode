package meituan.t4;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            int[] x = new int[n + 1];
            int[] y = new int[n + 1];
            int[] z = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                x[i] = cin.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                y[i] = cin.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                z[i] = cin.nextInt();
            }
            long[] ms = new long[n + 1];
            int minF = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                minF = Math.min(minF, z[i]);
                if(x[i] == y[i]){
                    ms[i] = 0;
                    continue;
                }
                ms[i] = ms[i - 1];
                if (x[i] > y[i]) {
                    ms[i] = (long) (x[i] - y[i]) * minF;
                }
            }

            int m = cin.nextInt();
            for (int k = 0; k < m; k++) {
                int q = cin.nextInt();
                System.out.printf("%d ", ms[q]);
            }
        }
    }
}

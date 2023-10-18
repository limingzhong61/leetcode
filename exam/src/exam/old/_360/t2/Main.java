package exam.old._360.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] cs = in.next().toCharArray();
        if(n == 1){
            System.out.println(1);
            return;
        }
        long[] f = new long[n];
        final long mod = 1_000_000_000 + 7;
        f[0] = f[1] = 1;
        if (cs[0] == '1' || ((cs[0] == '2' && cs[1] <= '6'))) {
            f[1] = 2;
        }
        for (int i = 2; i < n; i++) {
            if (cs[i - 1] == '1' || ((cs[i - 1] == '2' && cs[i] <= '6'))) {
                f[i] = (f[i - 1] + f[i-2]) % mod;
            } else {
                f[i] = f[i - 1];
            }
        }
        System.out.println(f[n-1]);
    }
}

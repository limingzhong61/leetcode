package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;

/**
 * 6
 * 2 2 4 5 1 2
 * <p>
 * 3
 * 1 1 1
 * <p>
 * 2
 * 10 100
 */
public class Main1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        long ans = 0;
        long mod = 1_000_000_000 + 7;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n - i - 1;
            long t = (((long) (i+1) * (i+2)) / 2) % mod;
            t = ((t * a[i]) % mod * (r + 1)) % mod;
            ans = (ans + t) % mod;
            //for (int j = 0; j <= i; j++) {
            //    long dis = i - j + 1;
            //    long t = ((dis * a[i]) % mod * (r + 1)) % mod;
            //    ans = (ans + t) % mod;
            //}
        }
        System.out.println(ans);
    }
}
/**
 * 4
 * 3 7 9
 * 1 2 4
 * 1 11 12
 * 12345 98765 56789
 */
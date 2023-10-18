package exam.old.gld.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }

        int[] e = new int[n];
        int[] max = new int[n];
        max[0] = a[0];
        int ans = a[0];
        for (int i = 1; i < n; i++) {
            max[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (s[j] + t[j] <= s[i]) {
                    max[i] = Math.max(max[i], max[j] + a[i]);
                }
            }
            ans = Math.max(ans, max[i]);
        }
        System.out.println(ans);
    }
}

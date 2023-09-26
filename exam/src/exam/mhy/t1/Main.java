package exam.mhy.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sumA += a[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            sumB += b[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,sumA ^(sumB - b[i]));
            ans = Math.max(ans,sumB ^(sumA - a[i]));
        }

        System.out.println(ans);
    }
}
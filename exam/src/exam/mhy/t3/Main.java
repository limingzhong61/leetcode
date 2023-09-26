package exam.mhy.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        final  long mod = 1_000_000_000 + 7;
        long ans = 0;
        for(int i = 0; i < n; i++){
            int min = a[i],max = a[i];
            for(int j = i+1; j < n; j++){
                long cnt = ((long) a[i] * a[j]) % mod;
                ans += ((j - i) * cnt) % mod;
            }
        }
        System.out.println(ans);
    }
}

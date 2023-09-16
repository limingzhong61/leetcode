package exam.old.intern.xiaohongshu.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();
        final int mod = (int) (1e9+7);
        long res = 0;
        int[] nums = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            nums[i] = cin.nextInt();
            max = Math.max(max,nums[i]);
        }
        long[] f = new long[max+1];
        f[0] = 1;
        for(int i = 1; i <= max; i++){
            f[i] = (f[i-1] * (i+1) + 1) % mod;
        }
        for(int i = 0; i < n; i++){
            res = (res + f[nums[i]]) % mod;
        }
        System.out.println(res);






    }
}

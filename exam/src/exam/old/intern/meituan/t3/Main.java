package exam.old.intern.meituan.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, m, s;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            m = cin.nextInt();
            s = cin.nextInt();
            int[] nums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nums[i] = cin.nextInt();
            }
            // f表示[0,i]的最小值
            long[] f = new long[n + 1];
            Arrays.fill(f, Long.MAX_VALUE);
            f[0] = 0;
            for (int i = 1; i <= n; i++) {
                int u = -1, v = Integer.MAX_VALUE;
                //long sum = 0;
                for (int j = i; j >= 1; j--) {
                    u = Math.max(u, nums[j]);
                    v = Math.min(v, nums[j]);
                    //sum += nums[j];
                    //long bagCnt = sum / m;
                    //if (sum % m != 0) bagCnt++; // 有多余的需要放
                    int len = i - j + 1; // 装入水果数量
                    f[i] = Math.min(f[i], (f[j - 1] + s + len * (long) Math.floor((u + v) * 1.0 / 2)));
                }
            }
            System.out.println(f[n]);
        }
    }
}

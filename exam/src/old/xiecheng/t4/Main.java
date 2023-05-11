package old.xiecheng.t4;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            final long mod = (long) (1e9 + 7);
            //System.out.println(mod);
            long res = 0;
            for (int i = 0; i < n; i++) {
                res = (res + (long) nums[i] * (nums[i] + 1) / 2) % mod;
            }
            for (int i = 0; i < n; i++) {
                for (int a = i - 1, b = i + 1; a >= 0 && b < n; a--, b++) {
                    if (nums[a] == nums[b]) {
                        res = (res + nums[a]) % mod;
                    }else { // 不相等，后序的不能为回文串
                        res = (res + Math.min(nums[a],nums[b])) % mod;
                        break;
                    }
                }
            }

            System.out.println(res);
        }

    }
}

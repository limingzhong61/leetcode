package exam.old.webank.t2.t22;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            int[] nums = new int[n];
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            int sum = IntStream.of(nums).sum();
            //System.out.println(sum);

            Arrays.fill(f, Integer.MAX_VALUE);
            f[0] = nums[0];
            for (int i = 1; i < n; i++) {
                f[i] = Math.min(0, f[i - 1]) + nums[i];
            }
            for (int i = 1; i < n; i++) {
                f[i] = Math.min(f[i], f[i - 1]);
            }

            int[] f2 = new int[n];
            Arrays.fill(f2,Integer.MAX_VALUE);
            f[n-1] = nums[n-1];
            for (int i = n - 2; i >= 0; i--) {
                f2[i] = Math.min(0, f2[i + 1]) + nums[i];
            }
            for (int i = n - 2; i >= 0; i--) {
                f2[i] = Math.min(f2[i], f2[i+1]);
            }

            int min = Math.min(f[0]+f2[1],f[n-2]+f2[n-1]);
            for (int i = 1; i < n - 1; i++) {
                min = Math.min(min, Math.min(f[i - 1] + f2[i], f[i] + f2[i + 1]));
            }
            if(min > 0) min = 0;
            if(f2[0] > 0) min = Math.min(min,f[n-1]);
            else if (f[n-1] > 0){
                min = Math.min(min,f2[0]);
            }

            System.out.println(sum - min);
        }

    }
}

package old.webank.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            int[] nums = new int[n];
            int[][] f = new int[n][n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }

            for (int i = 0; i < n; i++) {
                f[i][i] = nums[i];
                for (int j = i + 1; j < n; j++) {
                    f[i][j] = f[i][j - 1] + nums[j];
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){

                }
            }
        }

    }
}

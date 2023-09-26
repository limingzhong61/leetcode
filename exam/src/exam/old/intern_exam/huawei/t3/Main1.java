package exam.old.intern_exam.huawei.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;


public class Main1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNextInt()) {
            int m = cin.nextInt();
            int[][] g = new int[m + 1][m + 1];
            int[][] len = new int[m + 1][m + 1];
            for(int[] x: g){
                Arrays.fill(x,Integer.MAX_VALUE);
            }

            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                int x = cin.nextInt();
                int y = cin.nextInt();
                int time = cin.nextInt();
                g[x][y] = time;
                len[x][y] = 1;
            }
            int x = cin.nextInt();
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= m; j++){
                    for(int k = 1; k <= m; k++){
                        if(g[i][k] != Integer.MAX_VALUE && g[k][j] != Integer.MAX_VALUE){
                            g[i][j] = Math.min(g[i][j],g[i][k] + g[k][j]);
                            len[i][j] = len[i][k] + len[k][j];
                        }
                    }
                }
            }
            int maxLen = 1;
            int minTime = Integer.MAX_VALUE;
            for(int i = 0; i <= m; i++){
                if(g[x][i] != 0 && len[x][i] >= maxLen){
                    maxLen = len[x][i];
                }
            }
            for(int i = 0; i <= m; i++){
                if(len[x][i] == maxLen){
                    minTime = Math.min(minTime, g[x][i]);
                }
            }
            System.out.println(maxLen + 1);
            System.out.println(minTime);
        }

    }
}

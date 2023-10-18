package exam.old.yitu.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] a = new int[n][6];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < 6; j++){
                a[i][j] =  in.nextInt();
            }
            Arrays.sort(a[i]);
        }

        dfs(a, k,0);
        System.out.println(ans);
    }
    static long ans = 0;
    private static void dfs(int[][] a, int k,int cur) {
        if(k == 0){
            ans++;
            return;
        }
        if(k < 0 || cur == a.length) return;
        for(int i = 0; i < 6; i++){
            dfs(a,k-a[cur][i],cur+1);
        }
    }

}

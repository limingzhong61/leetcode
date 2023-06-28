package exam.old.xiecheng.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m,n;
        m = cin.nextInt();
        n = cin.nextInt();
        int cnt = 0;
        char[][] grid = new char[m][n];
        for(int i = 0; i < m; i++){
            grid[i] = cin.next().toCharArray();
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                char[] record = new char[26];
                for(int a = 0; a < 2; a++){
                    for(int b = 0; b < 2; b++){
                        record[grid[i-a][j-b] - 'a']++;
                    }
                }
                if(record['y' - 'a'] > 0 &&record['o' - 'a'] > 0 &&record['u' - 'a'] > 0){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}

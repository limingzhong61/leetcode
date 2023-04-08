package meituan.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m, n, a;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            m = cin.nextInt();
            a = cin.nextInt();
            int row = n, col = m * a;
            String[][] map = new String[n][m];
            int[][] map2 = new int[row][col];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = cin.next();
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int nextI = i == n - 1 ? 0 : i + 1, nextJ = j == m - 1 ? 0 : j + 1;
                    for (int k = 0; k < a; k++) {
                        if (map[nextI][nextJ].charAt(k) != map[i][j].charAt(k)) {
                            cnt++;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}


//int[][] map = new int[row][col];
//int[][] map2 = new int[row][col];
//        for(int i = 0; i < n; i++){
//    int cnt = 0;
//    for(int j = 0; j < m; j++){
//    String next = cin.next();
//    map[i][cnt++] = next.charAt(0) - '0';
//    map[i][cnt++] = next.charAt(1) - '0';
//    }
//    }
//
//    for(int i = 0; i < row; i++){
//    int cnt = 0;
//    for(int j = 0; j < col; j++){
//    String next = cin.next();
//    map[i][cnt++] = next.charAt(0) - '0';
//    map[i][cnt++] = next.charAt(1) - '0';
//    }
//    }










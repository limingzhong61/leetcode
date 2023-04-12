<<<<<<< HEAD
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









=======
package baidu.t1;
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            int cnt = 0;
            int i = 0;
            double sum = 0;
            for(int j = 0; j < k - 1; j++){
                sum += nums[i++];
            }
            long total = 0;
            int len = 0;
            for(; i < n; i++){
                total +=  nums[i];
                len++;
            }
            sum += total *1.0 / len;
            System.out.println(sum);
        }
    }
}
>>>>>>> f0707b453829379a33caafde07df465824c3cc1b

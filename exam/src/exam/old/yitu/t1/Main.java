package exam.old.yitu.t1;
//package main
//注意不要添加包名称，否则会报错。

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }



        int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int k = 0; k < m; k++) {
            int x = in.nextInt();
            int y = in.nextInt();

            x = n - x + 1;

            if(matrix[x][y] == -1){
                System.out.println("empty!");
            }

            int cnt = 0;
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n + 1][n + 1];
            visited[x][y] = true;
            int start = matrix[x][y];
            matrix[x][y] = -1;

            q.add(new int[]{x, y});
            while (!q.isEmpty()) {
                cnt++;
                int[] poll = q.poll();
                int a= poll[0];
                int b= poll[1];
                for(int[] nx : next){
                    int nextX = a + nx[0];
                    int nextY = b + nx[1];
                    if(nextX >= 1 && nextX <= n && nextX >= 1 && nextY <= n  && !visited[nextX][nextY] && matrix[nextX][nextY] == start){
                        q.add(new int[]{nextX,nextY});
                        visited[nextX][nextY] = true;
                        matrix[nextX][nextY] = -1;
                    }

                }
            }
            if(cnt == 1){
                matrix[x][y] = start;
                System.out.println("only one!");
                continue;
            }else{

                System.out.println(cnt);
                int cnt1 = 0;
                for(int i = 1; i <= n; i++){
                    if(matrix[i][y] == -1 ){
                        cnt1++;
                    }
                }
                // 左移
                if(cnt1 == n){
                    for(int i = 1; i <= n; i++){
                        int j = y + 1;
                        for(; j <= n; j++){
                            matrix[i][j-1] = matrix[i][j];
                            //if(matrix[i][j] == -1) break;
                        }
                        matrix[i][j-1] = -1;
                    }
                }
                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= n; j++){
                        if(matrix[i][j] != -1){
                            for(int c = 0; c < n; c++){

                            }
                        }
                    }
                }


            }

        }

    }
}

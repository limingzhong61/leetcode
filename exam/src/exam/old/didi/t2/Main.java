package exam.old.didi.t2;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[][] g = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = cin.nextInt();
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        long round = 0;
        int[][] nexts = {{1, 0}, {0, 1}, {-1, 0}, {0, -1},};
        while (!q.isEmpty()) {
            Queue<int[]> nextQ = new ArrayDeque<>();
            boolean success = false;
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int x = poll[0], y = poll[1];
                success = false;
                for (int[] next : nexts) {
                    int nextX = x + next[0];
                    int nextY = y + next[1];
                    if(nextX >= 0 && nextX < n && nextY>= 0 && nextY < m && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        if(nextX == n - 1 && nextY == m-1){
                            success = true;
                            break;
                        }
                        if(g[nextX][nextY] == 0){
                            q.add(new int[]{nextX,nextY});
                        }else{
                            nextQ.add(new int[]{nextX,nextY});
                        }
                    }
                }

                if(success) break;
            }
            q = nextQ;
            round++;
            if(success) break;
        }
        System.out.println(round - 1);
    }
}
/**
 5 3
 0 1 0
 0 1 1
 0 1 0
 1 0 0
 1 0 0


 5 3
 0 0 0
 0 0 0
 0 0 0
 0 0 0
 0 0 0


 5 3
 0 1 0
 0 1 0
 0 1 0
 0 1 0
 0 0 0


 */
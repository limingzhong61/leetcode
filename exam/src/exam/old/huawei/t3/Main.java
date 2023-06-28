package exam.old.huawei.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.*;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNextInt()) {
            int m = cin.nextInt();
            int[][] g = new int[m + 1][m + 1];
            int[][] len = new int[m + 1][m + 1];
            //for(int[] x: g){
            //    Arrays.fill(x,Integer.MAX_VALUE);
            //}

            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                int x = cin.nextInt();
                int y = cin.nextInt();
                int time = cin.nextInt();
                g[x][y] = time;
                len[x][y] = 1;
            }
            int x = cin.nextInt();
            // x,len
            Queue<int[]> q = new ArrayDeque<>();
            boolean visited[] = new boolean[m+1];
            q.add(new int[]{x,0});
            int maxTime = 0;
            while(!q.isEmpty()){
                int[] poll = q.poll();
                int v = poll[0];
                for(int i = 0 ; i <= m; i++){
                    if(g[v][i] != 0 && ! visited[i]){
                        visited[i] = true;
                        int time = poll[1] + g[i][i] + g[v][i];
                        maxTime = Math.max(maxTime, time);
                        q.add(new int[]{i,time});
                    }
                }
            }
            int cnt = 0;
            for(int i = 1; i <= m; i++){
                if(visited[i]){
                    cnt++;
                }
            }
            System.out.println(cnt);
            System.out.println(maxTime);
        }

    }
}

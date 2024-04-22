package exam.sample.t5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] map = new int[n + 1];
        int[] inDegree = new int[n+1];

        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            //代表第u个人暗恋第v个人
            map[v] = u;
            adj[v].add(u);
            inDegree[u]++;
        }
        long ans = 1;
        long mod = (long) (1e9 + 7);
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int u = i;
            int max = 0;
            long sonCnt = 0;
            if (inDegree[u] == 0){
                System.out.println(u);
                System.out.println("------");
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{u,1});

                //visited[u]
                while(!q.isEmpty()){
                    int[] poll = q.poll();
                    int x = poll[0];
                    max = Math.max(max,poll[1]);
                    //System.out.println(x);
                    if(adj[x].isEmpty()){
                        sonCnt++;
                    }
                    for(int y : adj[x]){
                        q.add(new int[]{y,poll[1] + 1});
                    }
                }
                System.out.println(sonCnt);
                System.out.println(max);
                sonCnt = (sonCnt * (sonCnt + 1) / 2) %mod;
                sonCnt = (sonCnt + max - 1) % mod;
                ans = (ans * (sonCnt + 1)) % mod;
            }
        }
        System.out.println(ans - 1);
    }
}

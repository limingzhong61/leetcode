package exam.old.dj.t2;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k  = 0;  k < t;  k++) {
            int n = in.nextInt();
            int x = in.nextInt();
            ArrayList<Integer>[] adj = new ArrayList[n+1];
            for(int i =0 ; i <= n; i++){
                adj[i] = new ArrayList<>();
            }
            int[] inDegree = new int[n+1];
            int[] outDegree = new int[n+1];
            for (int i = 1; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                adj[a].add(b);
                inDegree[b]++;
                outDegree[a]++;
            }
            if(outDegree[x] == 0){
                System.out.println("win");
                continue;
            }


            int root = 0;
            for(int i = 1; i <= n; i++){
                if(inDegree[i] == 0){
                    root = i;
                }
            }

            int linkCnt = 0;
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{root,1});
            boolean[] visited = new boolean[n+1];
            visited[root] = true;
            while(!q.isEmpty()){
                int[] poll = q.poll();
                int u = poll[0];
                int cnt = poll[1];
                if(u == x){
                    linkCnt = cnt;
                    break;
                }
                for(int v : adj[u]){
                    if(!visited[v]){
                        visited[v] = true;

                        q.add(new int[]{v,cnt +1});
                    }
                }
            }

            //int subCnt = 0;
            //Queue<Integer> q1 = new ArrayDeque<>();
            //q1.add(x);
            //visited = new boolean[n+1];
            //visited[x] = true;
            //while(!q1.isEmpty()){
            //    int u = q1.poll();
            //    subCnt++;
            //    for(int v : adj[u]){
            //        if(!visited[v]){
            //            visited[v] = true;
            //            q1.add(v);
            //        }
            //    }
            //}
            //// 减去自己
            //subCnt -= 1;

            //
            int optCnt = n - linkCnt;
            System.out.println(optCnt);
            if(optCnt % 2 == 0){
                System.out.println("win");
            }else{
                System.out.println("lose");
            }

        }
    }
}

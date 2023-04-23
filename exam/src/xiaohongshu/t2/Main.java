package xiaohongshu.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.*;


public class Main {

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        //for(int i = 0; i < 10; i++){
        //    list.add(i);
        //}
        //list.sort((a,b) -> b -a);
        //System.out.println(list);

        Scanner cin = new Scanner(System.in);
        int n,k;
        n = cin.nextInt();
        k = cin.nextInt();
        // 'R' true
        boolean[] color = new boolean[n+1];
        int idx = 1;
        for(char c : cin.next().toCharArray()){
            color[idx++] = c == 'R';
        }
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        Arrays.setAll(adj,e -> new ArrayList<Integer>());
        for(int i = 1; i < n; i++){
            int x = cin.nextInt();
            int y = cin.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        boolean[] visited = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            if(color[i] && !visited[i]){
                // bfs
                Queue<Integer> queue = new ArrayDeque<>();
                // i, cnt
                queue.add(i);
                visited[i] = true;
                int cnt = 0;
                while(!queue.isEmpty()){
                    int v = queue.poll();
                    cnt++;
                    for(int w : adj[v]){
                        if(!visited[w] && color[w]){
                            visited[w] = true;
                            queue.add(w);
                        }
                    }
                }
                list.add(cnt);
            }
        }
        if(list.size() < k ){
            System.out.println(-1);
            return;
        }


        list.sort((a,b) -> b -a);
        System.out.println(list.get(k-1));
    }
}
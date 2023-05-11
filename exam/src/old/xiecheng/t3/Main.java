package old.xiecheng.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.*;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        long l, r;
        n = cin.nextInt();
        l = cin.nextLong();
        r = cin.nextLong();

        long[] val = new long[n + 1];
        int idx = 1;
        for (char c : cin.next().toCharArray()) {
            val[idx++] = c - '0';
        }

        ArrayList<Integer>[] adj  = new ArrayList[n+1];
        Arrays.setAll(adj,e-> new ArrayList<Integer>());
        for(int i = 1; i < n; i++){
            int x = cin.nextInt();
            int y = cin.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            Queue<long[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];

            queue.add(new long[]{i, val[i]});
            visited[i] = true;

            while (!queue.isEmpty()) {
                long[] poll = queue.poll();

                for (int w : adj[(int) poll[0]]) {
                    if (!visited[w]) {
                        visited[w] = true;
                        long nextVal = (poll[1] << 1 )+ val[w];

                        //System.out.println(i);
                        if (nextVal <= r && nextVal >= l) {
                            //System.out.printf("%d,%d\n",i,nextVal);
                            cnt++;
                        }
                        if (nextVal <= r) {
                            queue.add(new long[]{w, nextVal});
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

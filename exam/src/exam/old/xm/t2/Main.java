package exam.old.xm.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        String next = cin.next();
        String[] split = next.split(",");
        int[] inDegree = new int[n];
        for (String s : split) {
            String[] split1 = s.split(":");
            int x = Integer.parseInt(split1[0]);
            int y = Integer.parseInt(split1[1]);
            adj[x].add(y);
            inDegree[y]++;
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }


        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int u = q.poll();
            for (int v : adj[u]) {
                inDegree[v]--;
                if (!visited[v] && inDegree[v] == 0) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        int ans = cnt == n ? 1 : 0;
        System.out.println(ans);
    }
}

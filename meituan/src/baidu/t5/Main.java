package meituan.t5;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            ArrayList<Integer>[] g = new ArrayList[n + 1];
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<Integer>();
            }
            int[][] edge = new int[n + 1][2];
            for (int i = 2; i <= n; i++) {
                int x = cin.nextInt();
                g[i].add(x);
                g[x].add(i);
                edge[i][0] = i;
                edge[i][1] = x;
            }

            String next = cin.next();
            char[] color = next.toCharArray();
            int cnt = 0;
            for (int i = 2; i <= n; i++) {
                int a = edge[i][0];
                int b = edge[i][1];
                Arrays.fill(visited, false);
                visited[b] = true; // 断开a-b边
                HashSet<Character> set = new HashSet<>();
                boolean b1 = dfs(g, visited, a, set, color);

                // start with b
                Arrays.fill(visited, false);
                visited[a] = true; // 断开a-b边
                set.clear();
                boolean b2 = dfs(g, visited, b, set, color);
                if (b1 && b2){
                    cnt++;
                }

            }
            System.out.println(cnt);
        }

    }

    private static boolean dfs(ArrayList<Integer>[] g, boolean[] visited, int v, HashSet<Character> set, char[] color) {

        visited[v] = true;
        set.add(color[v-1]);
        if (set.size() == 3) {
            return true;
        }
        for (int x : g[v]) {
            if (!visited[x]) {
                if (dfs(g, visited, x, set, color)) {
                    return true;
                }
            }
        }
        return false;
    }
}

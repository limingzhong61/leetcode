package exam.old.intern_exam.meituan.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Definition for a binary tree node.
 */
//class TreeNode {
//    public int val;
//    public TreeNode left;
//    public TreeNode right;
//
//    public TreeNode() {
//    }
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//
//    public TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

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
            for (int i = 2; i <= n; i++) {
                int x = cin.nextInt();
                g[i].add(x);
                g[x].add(i);
            }
            int a = cin.nextInt();
            int b = cin.nextInt();
            int max = 1;
            max = Math.max(max, dfs(g, visited, a, 0));
            Arrays.fill(visited, false);
            max = Math.max(max, dfs(g, visited, b, 0));
            System.out.println(max);
        }

    }

    private static int dfs(ArrayList<Integer>[] g, boolean[] visited, int v, int len) {

        visited[v] = true;
        int max = len;
        for (int x : g[v]) {
            if (!visited[x]) {
                max = Math.max(max, dfs(g, visited, x, len + 1));
            }
        }
        return max;
    }
}

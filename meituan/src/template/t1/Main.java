package template.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
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

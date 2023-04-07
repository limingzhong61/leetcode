package meituan.t5;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            ArrayList<Integer>[] g = new ArrayList[n + 1];
            int[] color = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<Integer>();
            }
            for (int i = 2; i <= n; i++) {
                int x = cin.nextInt();
                g[x].add(i);
            }
            for (int i = 1; i <= n; i++) {
                color[i] = cin.nextInt();
            }
            System.out.println(dfs(g, color, 1));
        }
    }

    private static int dfs(ArrayList<Integer>[] g, int[] color, int i) {
        if (g[i].size() == 0) {
            return 1;
        }
        int leftIdx = g[i].get(0);
        int rightIdx = g[i].get(1);
        //if (g[leftIdx].size() == 0 && g[rightIdx].size() == 0) {
        //    return 1;
        //}
        int leftVal = dfs(g, color, leftIdx);
        int rightVal = dfs(g, color, rightIdx);
        if (color[i] == 1) { // red;
            return leftVal + rightVal;
        } else {
            return leftVal ^ rightVal;
        }
    }
}

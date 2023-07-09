package com.lmz.algorithm.recall.conbine;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
    /**
     * 枚举下一个数
     * 枚举下一个数选哪个
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, n, k);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int i, int k) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(ans, path, j, k - 1);
            path.remove(path.size() - 1);
        }
    }


    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 思路：选或者不选，最后判断是否是k个
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, 1, n, k);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int i, int n, int k) {
        if (i == n + 1) {
            if (path.size() == k) ans.add(new ArrayList<>(path));
            return;
        }
        //不选
        dfs(ans, path, i + 1, n, k);
        //选
        path.add(i);
        dfs(ans, path, i + 1, n, k);
        path.remove(path.size() - 1);
    }


    class Solution {
        /**
         * 利用子集生成的思想
         * 位向量法：构造一个位向量B[i]，而不是直接构造子集A本身，
         * 中当B[i]==1时表示A[i]的的元素被选取
         */
        public List<List<Integer>> combine(int n, int k) {
            boolean[] b = new boolean[n + 1];
            subset(n, b, 1, k);
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();

        private void subset(int n, boolean[] b, int cur, int k) {
            if (k < 0) {  //选取元素过多
                return;
            }
            if (cur == n + 1) {
                if (k == 0) {
                    List<Integer> temp = new ArrayList<>();
                    for (int i = 1; i <= n; i++) {
                        if (b[i]) {      //添加当前选取元素到集合
                            temp.add(i);
                        }
                    }
                    res.add(temp);
                }
                return;
            }
            b[cur] = true;     //选第cur个元素
            subset(n, b, cur + 1, k - 1);
            b[cur] = false;     //不选第cur个元素
            subset(n, b, cur + 1, k);
        }
    }

    public static void main(String[] args) {
        Combine77 combine77 = new Combine77();
        System.out.println(combine77.combine(4, 2));
    }
}

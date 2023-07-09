package com.lmz.util.recall;

import java.util.ArrayList;
import java.util.List;

public class CombineUtil {
    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 思路：选或者不选，最后判断是否是k个
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
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



    public static void main(String[] args) {
        CombineUtil combine77 = new CombineUtil();
        System.out.println(combine77.combine(4, 2));
    }
}

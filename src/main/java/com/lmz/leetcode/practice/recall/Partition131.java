package com.lmz.leetcode.practice.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-15 22:37
 */
public class Partition131 {
    List<List<String>> ans = new ArrayList<>();
    int n = 0;

    /**
     * 假设每对相邻字符之间有个逗号，那么就看每个逗号是选还是不选。
     */
    public List<List<String>> partition(String s) {
        n = s.length();
        this.s = s;
        dfs(0, 0);
        return ans;
    }

    List<String> path = new ArrayList<>();
    private String s;
    private boolean isPalindrome(int left, int right) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }
    private void dfs(int i, int start) {
        if (i == n) {
            ans.add(new ArrayList<>(path)); // 固定答案
            return;
        }
        // 不选 i 和 i+1 之间的逗号（i=n-1 时右边没有逗号）
        if (i < n - 1)
            dfs(i + 1, start);
        // 选 i 和 i+1 之间的逗号
        if(isPalindrome(start, i)){
            path.add(s.substring(start, i + 1));
            dfs(i + 1, i + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }
}

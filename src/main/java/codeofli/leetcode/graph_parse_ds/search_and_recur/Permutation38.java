package codeofli.leetcode.graph_parse_ds.search_and_recur;

import java.util.*;

public class Permutation38 {

    /**
     * 回溯：
     * 注意还需要去重,故用Set保存
     * "aab" 只有["aba","aab","baa"]，不是["aab","aba","aab","aba","baa","baa"]
     */
    public String[] permutation1(String s) {
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] mark = new boolean[s.length()];
        recur(0, sb, s, res, mark);
        return res.toArray(new String[0]);
    }

    private void recur(int cur, StringBuilder sb, String s, Set<String> res, boolean[] mark) {
        if (cur == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!mark[i]) {
                mark[i] = true;
                sb.append(s.charAt(i));
                recur(cur + 1, sb, s, res, mark);
                sb.deleteCharAt(sb.length() - 1);
                mark[i] = false;
            }
        }
    }

    /*递归函数中设定一个规则，保证在填每一个空位的时候重复字符只会被填入一次。具体地，我们首先对原字符串排序，保证相同的字符都相邻，
    在递归函数中，我们限制每次填入的字符一定是这个字符所在重复字符集合中「从左往右第一个未被填入的字符」
    */
    List<String> res;
    boolean[] vis;

    public String[] permutation2(String s) {
        int n = s.length();
        res = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        return res.toArray(new String[0]);
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            res.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }

            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }

    /**
     * leetcode: 下一次排列，dfs，每次固定住第i位，则循环就能从i+1位开始
     */
    List<String> ans;

    public String[] permutation(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        dfs(0,arr,  n);
        return res.toArray(new String[0]);
    }

    public void dfs(int x, char[] c, int n) {
        if (x == n) {
            ans.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < n; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(x, i, c);// 交换，将 c[i] 固定在第 x 位
            dfs(x + 1, c, n);// 开启固定第 x + 1 位字符
            swap(x, i, c);// 恢复交换
        }
    }

    void swap(int a, int b, char[] c) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        Permutation38 permutation38 = new Permutation38();
        System.out.println(Arrays.toString(permutation38.permutation("abc")));
        System.out.println(Arrays.toString(permutation38.permutation("aab")));
        System.out.println(Arrays.toString(permutation38.permutation("aaaaa")));
    }
}

package com.lmz.leetcode.practice.contest.old.c139;

public class MaxPalindromes {
    public int maxPalindromes(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (cs[i] == cs[i - 1]) {
                f[i - 1][i] = true;
            }
        }
        for (int len = 3; len < n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (cs[i] == cs[j] && f[i + 1][j - 1]) {
                    f[i][j] = true;
                }
                //System.out.printf("%s,%b\n",String.valueOf(cs,i,len),f[i][j]);
            }
        }
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0)
                dp[i] = dp[i - 1];
            for (int j = i - k + 1; j >= 0; j--) {
                if (f[j][i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        MaxPalindromes maxPalindromes = new MaxPalindromes();
        System.out.println(maxPalindromes.maxPalindromes("sjbxiufnaanqkwsqswkqrcznzcddhtuhtthuttjfuufjtcfywgecegwyhhnnhtozczirynhhnyrire", 3));
        //System.out.println(maxPalindromes.maxPalindromes("fttfjofpnpfydwdwdnns",2));
        //System.out.println(maxPalindromes.maxPalindromes("abaccdbbd",3));
    }
}

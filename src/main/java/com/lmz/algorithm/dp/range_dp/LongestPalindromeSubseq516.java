package com.lmz.algorithm.dp.range_dp;

/**
 * @author: limingzhong
 * @create: 2023-07-01 10:13
 */
public class LongestPalindromeSubseq516 {
    /**
     * dp:
     * f[i][j]表示s[i-j]最长回文长度,其中 j > i
     ***循环顺序:**
     * - `f[i] `从`f[i＋1]`转移过来，所以i要倒序枚举
     * - `f[i][j]`从`f[i][j-1]`转移过来，所以j要正序枚举
     * - 答案为`f[0][n -1]`
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] f = new int[n][n];
        for(int i = n - 1; i >= 0; i--){
            f[i][i] = 1;
            for(int j = i+1; j < n; j++){ // j > i
                if(cs[i] == cs[j]){
                    f[i][j] = f[i+1][j-1] +2;
                }else{
                    f[i][j] = Math.max(f[i+1][j],f[i][j-1]);
                }
            }
        }
        return f[0][n-1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq516 longestPalindromeSubseq516 = new LongestPalindromeSubseq516();
        System.out.println(longestPalindromeSubseq516.longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq516.longestPalindromeSubseq("bbbab") == 4);
    }
}

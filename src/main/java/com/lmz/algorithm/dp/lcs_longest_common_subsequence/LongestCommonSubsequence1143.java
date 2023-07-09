package com.lmz.algorithm.dp.lcs_longest_common_subsequence;

/**
 * @author: limingzhong
 * @create: 2023-06-29 15:06
 */
public class LongestCommonSubsequence1143 {
    /**
     * dp
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m =text1.length(),n = text2.length();
        // f[i][j]表示t1[0,i-1]和t2[0,j-1]序列的最大长度
        int[][] f = new int[m+1][n+1];
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    f[i+1][j+1] = f[i][j] + 1;
                }else{
                    f[i+1][j+1] = Math.max(f[i+1][j],f[i][j+1]);
                }
            }
        }
        return f[m][n];
    }

}

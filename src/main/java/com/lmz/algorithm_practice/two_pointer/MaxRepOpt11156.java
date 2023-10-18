package com.lmz.algorithm_practice.two_pointer;

import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-06-03 10:47
 */
public class MaxRepOpt11156 {
    /**
     * lc:双指针
     * 用哈希表或数组 cnt 统计字符串 text中每个字符出现的次数。
     */
    public int maxRepOpt1(String text) {
        //1 <= text.length <= 20000
        char[] cs = text.toCharArray();
        int n = cs.length;
        int[] cnt = new int[26];

        for (char c : cs) {
            cnt[c - 'a']++;
        }
        int ans = 1;
        for(int left = 0;left < n; left++){
            int right = left;
            while(right < n && cs[right] == cs[left]) right++;
            // 找到第一个不为 cs[left]的值
            right++;
            while(right < n && cs[right] == cs[left]) right++;
            ans = Math.max(ans,Math.min(right - left,cnt[cs[left] - 'a']));

        }
        return ans;
    }

    /**
     * @param text
     * @return
     */
    public int maxRepOpt1_1(String text) {
        int n = text.length();
        final int letterLen = 26;
        int[][] f0 = new int[n][letterLen];
        int[][] f1 = new int[n][letterLen];
        char[] cs = text.toCharArray();
        f0[0][cs[0] - 'a']++;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int x = cs[i] - 'a';
            f0[i][x] = f0[i - 1][x] + 1;
            max = Math.max(max, f0[i][x]);
            int preMax = IntStream.of(f0[i - 1]).max().getAsInt();
            f1[i][x] = f1[i][x] + 1;
            for (int j = 0; j < letterLen; j++) {
                f1[i][j] = preMax + 1;
                max = Math.max(max, f1[i][j]);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        MaxRepOpt11156 maxRepOpt11156 = new MaxRepOpt11156();
        System.out.println(maxRepOpt11156.maxRepOpt1("ababa"));
    }
}

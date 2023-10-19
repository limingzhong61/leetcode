package com.lmz.leetcode.practice.contest.old;

/**
 * undo
 */
public class LongestSubsequence6099 {

    public int longestSubsequence(String s, int k) {
        char[] chars = s.toCharArray();
        int[] cntZero = new int[chars.length];
        cntZero[0] = chars[0] == '0' ? 1: 0;
        for(int i = 1; i < chars.length; i++){
            if (chars[i] == '0') {
                cntZero[i] = cntZero[i-1]+1;
            }
        }
        for (int len = chars.length; len >= 1; len--) {
            for (int i = 0; i <= chars.length - len; i++) {
                int res = 0;
                for (int j = chars.length-1; j >= i + len; j++) {
                    res <<= 1;
                    res += chars[j] - '0';
                }
                if(res <k){
                    return len;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LongestSubsequence6099 longestSubsequence6099 = new LongestSubsequence6099();
        System.out.println(longestSubsequence6099.longestSubsequence("1001010", 5));
    }
}

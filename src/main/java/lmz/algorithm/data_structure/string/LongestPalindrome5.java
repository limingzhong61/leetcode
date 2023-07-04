package lmz.algorithm.data_structure.string;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome5 {
    /**
     * leetcode-中心扩展法：
     * 所有的状态在转移的时候的可能性都是唯一的。
     * 可以从每一种边界情况开始「扩展」，也可以得出所有的状态对应的答案。
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
    /**
     * 状态：(length,i,j)，长度为length的子回文串[i,j],length可以省略
     * f[i][j] == true表示[i,j]为回文串（i < j）
     *
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            if (cs[i] == cs[i - 1]) {
                f[i-1][i] = true;
                left = i - 1;
                right = i;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (cs[i] == cs[j] && f[i + 1][j - 1]) {
                    f[i][j] = true;
                    left = i;
                    right = j;
                }
            }
        }
        return String.copyValueOf(cs, left, right - left + 1);
    }

    /**
     * f[i][j] 表示 s[i,j]中以i,j结尾的最长回文子串长度
     dp: dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] cs =  s.toCharArray();
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++){
            f[i][i] = 1;
        }
        int max = 0;
        String ans = String.valueOf(cs[0]);
        // 每次从[0,1]  [1,2],[0,2], [2,3],[1,3],[0,3]开始扩展
        for(int j = 0; j < n; j++){
            for(int i = j-1; i >= 0; i--){
                if(cs[i] == cs[j] && ((i+1 >= j-1) || f[i+1][j-1] > 0)){
                    f[i][j] = f[i+1][j-1] + 2;
                    if(f[i][j] > max){
                        max = f[i][j];
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindrome5 longestPalindrome = new LongestPalindrome5();
        testCase(longestPalindrome, "babad", "aba");
        testCase(longestPalindrome, "aacabdkacaa", "aca");
        testCase(longestPalindrome, "cbbd", "bb");
        testCase(longestPalindrome, "ccc", "ccc");
    }

    private static void testCase(LongestPalindrome5 longestPalindrome, String cbbd, String bb) {
        System.out.println(longestPalindrome.longestPalindrome(cbbd));
        System.out.println(longestPalindrome.longestPalindrome(cbbd).equals(bb));
    }
}

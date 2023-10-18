package com.lmz.algorithm_practice.two_pointer.same_direction_aka_slide_window;

/**
 * @author: limingzhong
 * @create: 2023-04-23 19:34
 */
public class BalancedString1234 {
    class Solution {
        public int balancedString(String S) {
            var s = S.toCharArray();
            var cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
            for (var c : s) ++cnt[c];
            int n = s.length, m = n / 4;
            if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m)
                return 0; // 已经符合要求啦
            int ans = n, left = 0;
            for (int right = 0; right < n; right++) { // 枚举子串右端点
                --cnt[s[right]];
                while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                    ans = Math.min(ans, right - left + 1);
                    ++cnt[s[left++]]; // 缩小子串
                }
            }
            return ans;
        }
    }

    static class SolutionMy {
        /**
         * 同向双指针： 当l,r外的子串数 < n/4时，可以通过翻转符合条件
         * @param s
         * @return
         */

        public int balancedString(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int[] counter = new int[26];
            for (char c : cs) {
                counter[c - 'A']++;
            }
            int[] need = new int[26];
            char[] qwer = new char[]{'Q', 'W', 'E', 'R'};
            for (int i = 0; i < 4; i++) {
                need[qwer[i] - 'A'] = Math.max(counter[qwer[i] - 'A'] - n / 4,0);
            }
            int left = 0, minLen = n + 1;

            int[] copy = new int[26];
            for (int right = 0; right < n; right++) {
                copy[cs[right] - 'A']++;
                while (left <= right && copy[cs[left] - 'A'] >  need[cs[left] - 'A']) {
                    copy[cs[left++] - 'A'] --;
                }
                if (judge(n, need, copy,qwer)) {
                    minLen = Math.min(minLen, right - left + 1);
                }
            }
            return minLen;
        }

        private boolean judge(int n, int[] need, int[] copy,char[] qwer) {
            for (int i = 0; i < 4; i++) {
                if (need[qwer[i] - 'A'] > copy[qwer[i] - 'A']) {
                    return false;
                }
            }
            return true;
        }
    }

    //public static void main(String[] args) {
    //    Solution solution = new Solution();
    //    System.out.println(solution.balancedString("WWEQERQWQWWRWWERQWEQ"));
    //
    //}
}

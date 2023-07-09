package com.lmz.algorithm.other.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-04-27 10:13
 */
public class LongestStrChain1048 {
    class Solution {
        /**
         * 暴力模拟
         */
        public int longestStrChain(String[] words) {
            int n = words.length;
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            //System.out.println(Arrays.toString(words));
            // f[i] 表示word[i]的最长链数
            var f = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                f[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (words[i].length() - 1 > words[j].length()) {
                        break;
                    } else if (words[i].length() - 1 == words[j].length()) {
                        if (judge(words[j], words[i])) {
                            f[i] = Math.max(f[i],f[j] + 1);
                        }
                    }
                }
                //System.out.printf("%d,%d\n",i,f[i]);
                max  = Math.max(max,f[i]);
            }
            return max;
        }

        /**
         * b.len - 1 = a.len;
         */
        private boolean judge(String a, String b) {
            int i = 0, j = 0;
            int diff = 1;
            while (i < a.length() && j < b.length()) {
                if (a.charAt(i) != b.charAt(j)) {
                    j++;
                    diff--;
                    if (diff < 0) {
                        return false;
                    }
                    continue;
                }
                i++;
                j++;
            }
            //有可能有 “xb” “xbc” 的 情况
            return i == a.length() && j == b.length() || i == a.length() && j + 1 == b.length();
        }
    }

    class Solution1 {
        /**
         * 灵神，利用hash表和字符串拼接判断链长，代码更加简洁
         */
        private Map<String, Integer> ws = new HashMap<>();

        public int longestStrChain(String[] words) {
            for (var s : words)
                ws.put(s, 0); // 0 表示未被计算
            int ans = 0;
            for (var s : ws.keySet())
                ans = Math.max(ans, dfs(s));
            return ans;
        }

        private int dfs(String s) {
            int res = ws.get(s);
            if (res > 0) return res; // 之前计算过
            for (int i = 0; i < s.length(); i++) { // 枚举去掉 s[i]
                var t = s.substring(0, i) + s.substring(i + 1);
                if (ws.containsKey(t)) // t 在 words 中
                    res = Math.max(res, dfs(t));
            }
            ws.put(s, res + 1); // 记忆化
            return res + 1;
        }
    }
}

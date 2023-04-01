package lmz.leetcode.dp.not_usual;

/**
 * @author: limingzhong
 * @create: 2023-04-01 14:27
 */
public class MinCutII094 {
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();

            // g[l][r] 代表 [l,r] 这一段是否为回文串
            boolean[][] g = new boolean[n + 1][n + 1];
            for (int r = 1; r <= n; r++) {
                for (int l = r; l >= 1; l--) { //从 r倒推，长度依次增加
                    // 如果只有一个字符，则[l,r]属于回文
                    if (l == r) {
                        g[l][r] = true;
                    } else {
                        // 在 l 和 r 字符相同的前提下
                        if (cs[l - 1] == cs[r - 1]) {
                            // 如果 l 和 r 长度只有 2；或者 [l+1,r-1] 这一段满足回文，则[l,r]属于回文
                            if (r - l == 1 || g[l + 1][r - 1]) {
                                g[l][r] = true;
                            }
                        }
                    }
                }
            }

            // f[r] 代表将 [1,r] 这一段分割成若干回文子串所需要的最小分割次数
            int[] f = new int[n + 1];
            for (int r = 1; r <= n; r++) {
                // 如果 [1,r] 满足回文，不需要分割
                if (g[1][r]) {
                    f[r] = 0;
                } else {
                    // 先设定一个最大分割次数（r 个字符最多消耗 r - 1 次分割）
                    f[r] = r - 1;
                    // 在所有符合 [l,r] 回文的方案中取最小值
                    for (int l = 1; l <= r; l++) {
                        if (g[l][r]) f[r] = Math.min(f[r], f[l - 1] + 1);
                    }
                }
            }

            return f[n];
        }
    }

}


package com.lmz.algorithm_practice.other.pointer_to_offer;

import com.lmz.algorithm_learning.util.matrix.MatrixUtil;

import java.util.*;

public class IsMatch19 {
    /**
     * dp:
     * dp[0][0] = true： 代表两个空字符串能够匹配。
     */
    public boolean isMatch3(String s, String p) {
        int n = s.length() + 1;
        int m = p.length() + 1;
        boolean[][] dp = new boolean[n][m];
        //空串默认为true;
        dp[0][0] = true;
        // 初始化首行
        /**
         * dp[0][j] = dp[0][j - 2] 且 p[j - 1] = '*'： 首行 s 为空字符串，
         * 因此当 p 的偶数位为 * 时才能够匹配（即让 p 的奇数位出现 0 次，保持 p 是空字符串）。
         * 因此，循环遍历字符串 p ，步长为 2（即只看偶数位）。
         */
        for (int j = 2; j < m; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //判断p的第j位是不是*，是*则判断前一位与i是否相等，相等则可以匹配0次或者多次
                if (p.charAt(j - 1) == '*') {
                    //可以让*匹配空串
                    if (dp[i][j - 2]) dp[i][j] = true;                                           // 1.
                    //其他两者情况
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                } else {//不是'*'，则只需要看上一位i和上一位j是否匹配,如aab和aa.
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                    else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                }
            }
        }
        return dp[n - 1][m- 1];
    }

    /**
     * 思路： 记忆化搜索
     * 遇到".*" 或者s[i] == p[j] && p[j+1] == '*'有两种走法
     * recur(i + 1, j, s, p) || recur(i, j + 2, s, p);
     * "abcd" ".*d"
     * "aaa" "ab*a*c*a"
     */
    int[][] dp = new int[21][31];

    public boolean isMatch2(String s, String p) {
        return recur(0, 0, s, p);
    }


    private boolean recur(int i, int j, String s, String p) {
        while (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '.') {
                //".*"
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    if (dp[i + 1][j] == 0) {
                        dp[i + 1][j] = recur(i + 1, j, s, p) ? 1 : -1;
                    }
                    if (dp[i][j + 2] == 0) {
                        dp[i][j + 2] = recur(i, j + 2, s, p) ? 1 : -1;
                    }
                    dp[i][j] = (dp[i + 1][j] == 1 || dp[i][j + 2] == 1) ? 1 : -1;
                    return dp[i][j] == 1;
                } else {
                    i++;
                    j++;
                }
            } else {
                //"[]*"
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    if (s.charAt(i) == p.charAt(j)) {
                        if (dp[i + 1][j] == 0) {
                            dp[i + 1][j] = recur(i + 1, j, s, p) ? 1 : -1;
                        }
                        if (dp[i][j + 2] == 0) {
                            dp[i][j + 2] = recur(i, j + 2, s, p) ? 1 : -1;
                        }
                        dp[i][j] = (dp[i + 1][j] == 1 || dp[i][j + 2] == 1) ? 1 : -1;
                        return dp[i][j] == 1;
                    } else { //不匹配
                        j += 2;
                    }
                } else if (s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else {
                    dp[i][j] = -1;
                    return false;
                }
            }
        }
        //可能以"([]*){n}"结尾
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        int tempJ = j;
        while (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            j += 2;
        }
        dp[i][tempJ] = dp[i][j] = (s.length() == i && j == p.length()) ? 1 : -1;
        return dp[i][j] == 1;
    }

    /**
     f[i][j] 代表 A 的前 i 个和 B的前 j 个能否匹配
     */
    public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        IsMatch19 isMatch19 = new IsMatch19();

        Map<String[], Boolean> testMap = new LinkedHashMap<>() {{
            put(new String[]{"aa", "a"}, false);
            put(new String[]{"aa", "a*"}, true);
            put(new String[]{"ab", ".*"}, true);
            put(new String[]{"aab", "c*a*b"}, true);
            put(new String[]{"mississippi", "mis*is*p*."}, false);
            put(new String[]{"", "mis*is*p*."}, false);
            put(new String[]{"", ""}, true);
            put(new String[]{"s", ""}, false);
            put(new String[]{"aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"}, false);
            put(new String[]{"ab", ".*c"}, false);
            put(new String[]{"aaa", "ab*a*c*a"}, true);
            put(new String[]{"abcd", ".*d"}, true);
            put(new String[]{"", "c*c*"}, true);
            put(new String[]{"aaabaaaababcbccbaab", "c*c*.*c*a*..*c*"}, true);
            put(new String[]{"aab", "c*a*b"}, true);

        }};
        for (Map.Entry<String[], Boolean> testCase : testMap.entrySet()) {
            if (!isMatch19.isMatch(testCase.getKey()[0], testCase.getKey()[1]) == testCase.getValue()) {
                System.out.println("error:");
                System.out.println(Arrays.toString(testCase.getKey()));
                System.out.println("计算结果值：" + isMatch19.isMatch(testCase.getKey()[0], testCase.getKey()[1]));
                System.out.println("真实结果值：" + testCase.getValue());
                MatrixUtil.printMatrix(isMatch19.dp, testCase.getKey()[0].length() + 1, testCase.getKey()[1].length() + 1);

            }
            MatrixUtil.setZero(isMatch19.dp);
        }
    }
}

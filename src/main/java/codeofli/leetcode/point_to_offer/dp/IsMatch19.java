package codeofli.leetcode.point_to_offer.dp;

import codeofli.my.matrix.Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsMatch19 {
    /**
     * 思路： 记忆化搜索
     * 遇到".*" 或者s[i] == p[j] && p[j+1] == '*'有两种走法
     * recur(i + 1, j, s, p) || recur(i, j + 2, s, p);
     * "abcd" ".*d"
     * "aaa" "ab*a*c*a"
     */
    static int[][] dp = new int[21][31];
    public boolean isMatch(String s, String p) {
        return recur(0, 0, s, p);
    }


    private boolean recur(int i, int j, String s, String p) {
        while (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '.') {
                //".*"
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    if (dp[i+1][j] == 0) {
                        dp[i + 1][j] = recur(i + 1, j, s, p) ? 1 : -1;
                    }
                    if (dp[i][j + 2] == 0) {
                        dp[i][j + 2] = recur(i, j+2, s, p) ? 1 : -1;
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
                        if (dp[i+1][j] == 0) {
                            dp[i + 1][j] = recur(i + 1, j, s, p) ? 1 : -1;
                        }
                        if (dp[i][j + 2] == 0) {
                            dp[i][j + 2] = recur(i, j+2, s, p) ? 1 : -1;
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
                    return false;
                }
            }
        }
        //可能以"([]*){n}"结尾
        if(dp[i][j] != 0){
            return  dp[i][j] == 1;
        }
        int tempJ = j;
        while (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            j += 2;
        }
        dp[i][tempJ] = dp[i][j] = (s.length() == i && j == p.length()) ? 1 : -1;
        return dp[i][j] == 1;
    }
    ///**
    // * 思路： 搜索
    // * 遇到".*" 或者s[i] == p[j] && p[j+1] == '*'有两种走法
    // * recur(i + 1, j, s, p) || recur(i, j + 2, s, p);
    // * "abcd" ".*d"
    // * "aaa" "ab*a*c*a"
    // */
    //public boolean isMatch2(String s, String p) {
    //    return recur(0, 0, s, p);
    //}
    //
    //private boolean recur(int i, int j, String s, String p) {
    //    while (i < s.length() && j < p.length()) {
    //        if (p.charAt(j) == '.') {
    //            //".*"
    //            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
    //                return recur(i + 1, j, s, p) || recur(i, j + 2, s, p);
    //            } else {
    //                i++;
    //                j++;
    //            }
    //        } else {
    //            //"[]*"
    //            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
    //                if (s.charAt(i) == p.charAt(j)) {
    //                    return recur(i + 1, j, s, p) || recur(i, j + 2, s, p);
    //                }else{ //不匹配
    //                    j += 2;
    //                }
    //            } else if (s.charAt(i) == p.charAt(j)) {
    //                i++;
    //                j++;
    //            } else {
    //                return false;
    //            }
    //        }
    //    }
    //    //可能以"([]*){n}"结尾
    //    while (j < p.length() - 1 && p.charAt(j + 1) == '*') {
    //        j += 2;
    //    }
    //    return s.length() == i && j == p.length();
    //}

    /**
     * 思路： 模拟匹配,失败，无法解决下列式子
     * //"aaa"
     * "ab*a*c*a"
     */
    public boolean isMatch1(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '.') {
                //".*"直接无敌,匹配s全部
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    //只要“.*”后面没有字符就能成功匹配
                    return j + 2 == p.length();
                } else {
                    i++;
                    j++;
                }
            } else {

                char nowChar = p.charAt(j);
                //"[]*"

                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    while (i < s.length() && s.charAt(i) == nowChar) {
                        i++;
                    }
                    // 防止出现 s=“aaab”, p="a*ab"
                    j += 2;
                    while (j < p.length() && p.charAt(j) == nowChar) {
                        j++;
                    }
                } else if (s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        return s.length() == i && j == p.length();
    }

    public static void main(String[] args) {
        IsMatch19 isMatch19 = new IsMatch19();
        Map<String[], Boolean> testMap = new HashMap<>() {{
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
            put(new String[]{"aab","c*a*b"}, true);

        }};
        for (Map.Entry<String[], Boolean> testCase : testMap.entrySet()) {
            if (!isMatch19.isMatch(testCase.getKey()[0], testCase.getKey()[1]) == testCase.getValue()) {
                System.out.println("error:");
                System.out.println(Arrays.toString(testCase.getKey()));
                System.out.println("计算结果值：" + isMatch19.isMatch(testCase.getKey()[0], testCase.getKey()[1]));
                System.out.println("真实结果值：" + testCase.getValue());
                Matrix.printMatrix(dp,testCase.getKey()[0].length()+1,testCase.getKey()[1].length()+1);
                Matrix.setZero(dp);
            }
        }
    }
}

package exam.old.qunaer.t1;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 最长公共子序列逆序输出
     *
     * @param string1 string字符串
     * @param string2 string字符串
     * @return string字符串
     */
    public String maxSubsequenceAndReverse(String string1, String string2) {
        // write code here
        int len1 = string1.length(), len2 = string2.length();
        String[][] s = new String[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            Arrays.fill(s[i],"");
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (string1.charAt(i) == string2.charAt(j)) {
                    s[i+1][j+1] = s[i][j] + string1.charAt(i);
                } else {
                    if (s[i][j+1].length() > s[i+1][j].length()) {
                        s[i+1][j+1] = s[i][j + 1];
                    } else {
                        s[i+1][j+1] = s[i + 1][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder(s[len1][len2]);
        return  sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubsequenceAndReverse("abcde", "ace"));
    }
}
















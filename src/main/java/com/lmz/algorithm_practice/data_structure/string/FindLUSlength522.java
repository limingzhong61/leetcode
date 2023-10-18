package com.lmz.algorithm_practice.data_structure.string;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class FindLUSlength522 {
    /**
     * 暴力枚举
     */
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        //strs[i] 只包含小写英文字母
        int maxLen = -1;
        for (int i = 0; i < n; i++) {
            int iLen = strs[i].length();
            boolean contain = false;
            for (int j = 0; j < n; j++) {
                int jLen = strs[j].length();
                if(i == j){
                    continue;
                }
                if (iLen > jLen) {
                    continue;
                } else if (iLen == jLen) {
                    if (strs[i].equals(strs[j])) {
                        contain = true;
                        break;
                    }
                } else { //iLen < jLen
                    int a = 0;
                    for (int b = 0; b < jLen; b++) {
                        if (strs[j].charAt(b) == strs[i].charAt(a)) {
                            a++;
                            if (a == iLen) {
                                contain = true;
                                break;
                            }
                        }
                    }
                    if (contain) {
                        break;
                    }
                }
            }
            if (!contain) {
                maxLen = Math.max(maxLen, iLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        FindLUSlength522 findLUSlength522 = new FindLUSlength522();

        testCase(findLUSlength522, "[\"aaa\",\"aaa\",\"ab\"]", 2);

        testCase(findLUSlength522, "[\"aba\",\"cdc\",\"eae\"]", 3);
        testCase(findLUSlength522, " [\"aaa\",\"aaa\",\"aa\"]", -1);
    }

    private static void testCase(FindLUSlength522 findLUSlength522, String s, int i) {
        System.out.println(findLUSlength522.findLUSlength(TransformUtil.
                toStringArray(s)));
        System.out.println(findLUSlength522.findLUSlength(TransformUtil.
                toStringArray(s)) == i);
    }
}

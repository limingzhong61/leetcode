package com.lmz.algorithm.p.p_0_1000;

import com.lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-08-15 10:05
 */
public class FindReplaceString833 {
    /**
     * 记录每次需要替换的字符串和长度
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        var replaceStr = new String[n]; // 替换后的字符串
        var replaceLen = new int[n];    // 被替换的长度
        Arrays.fill(replaceLen, 1);     // 无需替换时 i+=1
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                replaceStr[idx] = targets[i];
                replaceLen[idx] = sources[i].length();
            }
        }

        var ans = new StringBuilder();
        for (int i = 0; i < n; i += replaceLen[i]) { // 无需替换时 i+=1
            if (replaceStr[i] == null) {
                ans.append(s.charAt(i));
            } else {
                ans.append(replaceStr[i]);
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        FindReplaceString833 findReplaceString833 = new FindReplaceString833();
        System.out.println(findReplaceString833.findReplaceString("wreorttvosuidhrxvmvo",
                TransformUtil.toIntArray("[14,12,10,5,0,18]"),
                TransformUtil.toStringArray("[\"rxv\",\"dh\",\"ui\",\"ttv\",\"wreor\",\"vo\"]"),
                TransformUtil.toStringArray("[\"frs\",\"c\",\"ql\",\"qpir\",\"gwbeve\",\"n\"]")));
    }
}

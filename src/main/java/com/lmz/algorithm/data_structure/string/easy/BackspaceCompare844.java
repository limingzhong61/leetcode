package com.lmz.algorithm.data_structure.string.easy;

public class BackspaceCompare844 {
    /**
     * 用栈的思维处理遍历过程
     * 因为删除的字符数=退格符的字符数，可以将普通字符压入栈中，
     * 当遇到退格字符时，删除普通字符。
     */
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public boolean backspaceCompare1(String s, String t) {
        return backString(s).equals(backString(t));
    }

    private String backString(String s) {
        StringBuilder sb = new StringBuilder();
        //倒着处理更容易
        int cnt = 0; // 统计需要消除#的个数
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                cnt++;
            } else {
                if (cnt == 0) {
                    sb.append(s.charAt(i));
                } else {
                    cnt--;
                }
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}

package com.lmz.leetcode.practice.p.easy;

/**
 * @author: limingzhong
 * @create: 2023-06-23 9:18
 */
public class MaximumValue2496 {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String s : strs) {

            int digit = 0;
            boolean isNum = true;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    digit = digit * 10 + s.charAt(i) - '0';
                } else {
                    digit = 0;
                    isNum = false;
                    break;
                }
            }
            if (isNum) {
                max = Math.max(max, digit);
            } else {
                max = Math.max(s.length(), max);
            }
        }
        return max;
    }
}

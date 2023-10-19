package com.lmz.leetcode.practice.other.medium.old;

/**
 * @author: limingzhong
 * @create: 2023-01-03 10:04
 */
public class AreNumbersAscending2042 {
    public boolean areNumbersAscending(String s) {
        int lastNumber = -1;
        char[] cs = s.toCharArray();
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(cs[i])) {
                int num = 0;
                while (i < len && Character.isDigit(cs[i])) {
                   num = num * 10 + cs[i] - '0';
                }
                if(num <= lastNumber){
                    return false;
                }
                lastNumber = num;
            }
        }
        return true;
    }
}

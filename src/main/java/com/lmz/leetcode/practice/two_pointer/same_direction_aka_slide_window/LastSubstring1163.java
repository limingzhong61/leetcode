package com.lmz.leetcode.practice.two_pointer.same_direction_aka_slide_window;

/**
 * @author: limingzhong
 * @create: 2023-04-24 16:42
 */
public class LastSubstring1163 {
    class Solution {
        /**
         * 我们使用双指针i和j，其中指针i指向当前字典序最大的子串的起始位置，
         * 指针j指向当前考虑的子串的起始位置。
         * 另外，用一个变量k记录当前比较到的位置。初始时i=0,j=1,k=0。
         */
        public String lastSubstring(String s) {
            int i = 0, j = 1, k = 0,n = s.length();
            char[] cs = s.toCharArray();
            for(; j + k < n; ){
                int d = cs[j + k] - cs[i + k];
                if(d == 0){
                    k++;
                }else if(d > 0){
                    i = Math.max(i + k + 1, j);
                    j = i + 1;
                    k = 0;
                }else{
                    j += k + 1;
                    k = 0;
                }
            }
            return s.substring(i);
        }
    }
}

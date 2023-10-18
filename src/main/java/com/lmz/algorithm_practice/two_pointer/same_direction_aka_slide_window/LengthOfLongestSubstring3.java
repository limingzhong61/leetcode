package com.lmz.algorithm_practice.two_pointer.same_direction_aka_slide_window;

import java.util.Arrays;
import java.util.HashMap;

public class LengthOfLongestSubstring3 {
    class Solution {
        /**
         * 同向双指针： r固定，枚举左端点
         */
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(),left = 0,res = 0;
            HashMap<Character,Integer> counter = new HashMap<>();
            char[] cs = s.toCharArray();    // 转换成 char[] 加快效率（忽略带来的空间消耗）
            for(int right = 0; right < n; right++){
                char c = s.charAt(right);
                counter.put(c,counter.getOrDefault(c,0)+1);
                while(counter.get(c) > 1){
                    counter.put(cs[left],counter.get(cs[left]) - 1);
                    left++;
                }
                res = Math.max(res,right - left + 1);
            }
            return res;
        }
    }



    /**
     * 双指针：left，right表示不重复的区间[left,right]
     * len = right - left + 1;
     * 其中，用一个map记录一个字符上一次出现的位置
     */
    public int lengthOfLongestSubstring(String s) {
        //s 由英文字母、数字、符号和空格组成
        int[] a = new int[128];
        Arrays.fill(a, -1);
        //0 <= s.length <= 5 * 10^4
        int maxLen = 0;
        for (int left = 0, right = 0; right < s.length();right++ ) {
            if (a[s.charAt(right)] == -1) { //没有被访问过
                maxLen = Math.max(maxLen, right - left + 1);
            } else { //有被访问过
                left = Math.max(left, a[s.charAt(right)] + 1); // left 更新到max(left,标记字符上一次的位置的下一个位置)
                maxLen = Math.max(maxLen, right - left + 1);
            }
            a[s.charAt(right)] = right; //标记字符上一次出现的位置

        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring3();
        testCase(lengthOfLongestSubstring3, "abcabcbb", 3);
        testCase(lengthOfLongestSubstring3, "bbbbb", 1);
        testCase(lengthOfLongestSubstring3, "pwwkew", 3);
    }

    private static void testCase(LengthOfLongestSubstring3 lengthOfLongestSubstring3, String pwwkew, int x) {
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring(pwwkew));
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring(pwwkew) == x);
    }
}

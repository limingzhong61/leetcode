package com.lmz.leetcode.practice.other.old.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring48 {
    /**
     * leetcode:
     * 滑动窗口，用set维护一个不重复的窗口
     *left,right 表示左右边界
     * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-l4yo/
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int n = s.length();
        for (int left = 0,right = 0; left < n; left++) {
            if(left != 0){
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(left-1));
            }
            //right = left;
            while(right < n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            // 第 left 到 right 个字符是一个极长的无重复字符子串
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    /**
     * 双指针 + 哈希表
     * dp代码优化：
     * 用hashMap记录字符上一次出现的位置index
     *
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        //记录左边界的值
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                //更新左指针 start,start应该取最大的值
                start = Math.max(start, map.get(s.charAt(i)));
            map.put(s.charAt(i), i);     // 哈希表记录
            maxLength = Math.max(maxLength, i - start); // 更新结果
        }
        return maxLength;
    }

    /**
     * 用hashMap记录字符上一次出现的位置index
     * dp[i]表示长的不包含重复字符的子字符串长度
     * if: map
     * dp[i] = dp[i-1]
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        int length = 1;
        map.put(s.charAt(0), 0);
        //记录左边界的值
        int start = -1;
        for (int i = 1; i < s.length(); i++) {
            // 没有包含字符
            if (map.get(s.charAt(i)) == null) {
                length++;
            } else {
                //start应该取最大的值
                start = Math.max(map.get(s.charAt(i)), start);
                length = i - start;
            }
            map.put(s.charAt(i), i);     // 哈希表记录
            maxLength = Math.max(maxLength, length); // 更新结果
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring48 lengthOfLongestSubstring48 = new LengthOfLongestSubstring48();
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("") == 0);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring(" ") == 1);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("abba") == 2);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("tmmzuxt") == 5);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("wobgrovw"));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("wobgrovw") == 6);
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("zwnigfunjwz"));
        System.out.println(lengthOfLongestSubstring48.lengthOfLongestSubstring("zwnigfunjwz") == 8);
    }
}

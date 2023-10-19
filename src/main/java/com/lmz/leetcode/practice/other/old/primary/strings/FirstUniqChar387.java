package com.lmz.leetcode.practice.other.old.primary.strings;

public class FirstUniqChar387 {
    /**
     * my
     */
    public int firstUniqChar(String s) {
        // s 只包含小写字母
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int length = chars.length;
        for(int i = length-1; i >= 0; --i){
            map[chars[i]-'a']++;
        }
        for(int i = 0; i < length; ++i){
            if(map[chars[i]-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

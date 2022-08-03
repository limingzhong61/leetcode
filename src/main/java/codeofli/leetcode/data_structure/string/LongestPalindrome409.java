package codeofli.leetcode.data_structure.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {
    /**
     * 1 <= s.length <= 2000
     * s 只能由小写和/或大写英文字母组成
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }
        int longest = 0;
        //一个单字符只有用一次，最中间
        boolean useOnce = false;
        for (var entry : cntMap.entrySet()) {
            Integer cnt = entry.getValue();
            if (!useOnce && cnt == 1) {
                longest++;
                useOnce = true;
            } else if (cnt > 1) {
                if(cnt % 2 == 1){
                    longest += cnt -1;
                    if(!useOnce){
                        longest++;
                    }
                }else {
                    longest += cnt;
                }
            }
        }
        return  longest;
    }
}

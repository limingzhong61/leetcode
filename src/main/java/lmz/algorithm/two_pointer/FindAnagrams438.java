package lmz.algorithm.two_pointer;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams438 {
    /**
     * 23.5.28
     * s 和 p 仅包含小写字母
     */
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return null;
        }
        int letterCnt = 26;
        int[] cntP = new int[letterCnt];
        for(char c : p.toCharArray()){
            cntP[c - 'p']++;
        }
        int[] cntS = new int[letterCnt];
        int lenP = p.length();
        char[] cs = s.toCharArray();
        for(int i = 0; i < lenP; i++){
            cntS[cs[i] -'a']++;
        }
        




    }

    /**
     * 双指针+hash
     * 异位词：只要字符出现次数相同即可，hash统计
     * s 和 p 仅包含小写字母
     * 1 <= s.length, p.length <= 3 * 104
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int pLen = p.length(), sLen = s.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] cntMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cntMap[p.charAt(i) - 'a']++;
            cntMap[s.charAt(i) - 'a']--;
        }
        if (check(cntMap)) {
            res.add(0);
        }
        for (int i = pLen; i < s.length(); i++) {
            cntMap[s.charAt(i - pLen) - 'a']--;
            cntMap[s.charAt(i) - 'a']++;
            if(check(cntMap)){
                res.add(i);
            }
        }
        return res;
    }

    boolean check(int[] a) {
        for (int i : a) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

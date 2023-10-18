package com.lmz.algorithm_practice.other.easy.old;

public class IsAnagramII032 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] sCnt = new int[26];
        int[] tCnt = new int[26];
        boolean diff = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                diff = true;
            }

            sCnt[s.charAt(i) - 'a']++;
            tCnt[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(sCnt[i] != tCnt[i]){
                return false;
            }
        }

        return diff;
    }
}

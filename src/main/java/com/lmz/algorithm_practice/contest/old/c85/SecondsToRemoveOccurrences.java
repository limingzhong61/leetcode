package com.lmz.algorithm_practice.contest.old.c85;

public class SecondsToRemoveOccurrences {
    public int secondsToRemoveOccurrences(String s) {
        int cnt = 0;
        while(true){
            if(!s.contains("01")){
                break;
            }
            s = s.replace("01","10");
            cnt++;
        }
        return cnt;
    }
}

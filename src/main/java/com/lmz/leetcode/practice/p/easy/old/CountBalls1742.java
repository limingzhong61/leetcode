package com.lmz.leetcode.practice.p.easy.old;

import java.util.HashMap;

public class CountBalls1742 {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        for(int i = lowLimit; i <= highLimit; i++){
            char[] chars = String.valueOf(i).toCharArray();
            int sum = 0;
            for(char c : chars){
                sum += c - '0';
            }
            cntMap.put(sum,cntMap.getOrDefault(sum,0) + 1);
        }
        int max = 0;
        for(var entry : cntMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        return max;
    }
}

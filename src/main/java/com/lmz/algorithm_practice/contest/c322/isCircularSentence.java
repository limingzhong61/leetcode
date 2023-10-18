package com.lmz.algorithm_practice.contest.c322;

public class isCircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        for(int i = 1; i < split.length; i++){
            if(split[i-1].charAt(split[i].length() - 1) != split[i].charAt(0)){
                return false;
            }
        }
        return split[0].charAt(0) == split[split.length - 1].charAt(split[split.length - 1].length() - 1);
    }
}

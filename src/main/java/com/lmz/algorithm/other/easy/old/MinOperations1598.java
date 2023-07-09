package com.lmz.algorithm.other.easy.old;

public class MinOperations1598 {
    //["d1/","d2/","../","d21/","./"]
    public int minOperations(String[] logs) {
        int distRoot = 0;
        for(String log : logs){
            if("../".equals(log)){
                if(distRoot != 0){
                    distRoot--;
                }
            }else if("./".equals(log)){
                continue;
            }else{
                distRoot++;
            }
        }
        return distRoot;
    }
}

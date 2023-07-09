package com.lmz.algorithm.other.medium.old;

import java.util.HashMap;

public class BeautySum1781 {
    public int beautySum(String s) {
        int n = s.length(),res = 0;
        char[] cs = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            //treeMap.put(cs[i],treeMap.getOrDefault(cs[i],0) + 1);
            for(int j = i; j < n; j++){
                map.put(cs[j],map.getOrDefault(cs[j],0) + 1);
                //int cnt = map.get(cs[j]);
                if(map.size() > 2){
                    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                    for(var entry : map.entrySet()){
                        max = Math.max(max,entry.getValue());
                        min = Math.min(min,entry.getValue());
                    }
                    if(max > min){
                        System.out.printf("%c,%c,%d,%d\n",cs[i],cs[j],max,min);
                        res += max - min;
                    }
                }
            }
        }
        return  res;
    }
}

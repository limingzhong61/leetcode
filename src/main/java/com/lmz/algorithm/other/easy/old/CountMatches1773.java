package com.lmz.algorithm.other.easy.old;

import java.util.*;

/**
 * @author: codeofli
 * @create: 2022-10-29 8:40
 */
public class CountMatches1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("type",0);
        map.put("color",1);
        map.put("name",2);
        int idx = map.get(ruleKey);
        int res = 0;
        for(var item : items){
            if(ruleValue.equals(item.get(idx))){
                res++;
            }
        }
        return res;
    }
}

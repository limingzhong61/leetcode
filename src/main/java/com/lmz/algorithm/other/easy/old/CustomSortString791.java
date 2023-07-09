package com.lmz.algorithm.other.easy.old;

import java.util.Arrays;
import java.util.HashMap;

public class CustomSortString791 {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i),i);
        }
        int len = s.length();
        Character[] cs = new Character[len];
        int idx = 0;
        for(char c : s.toCharArray()){
            cs[idx++] = c;
        }
        Arrays.sort(cs,(a,b) ->{
            return map.getOrDefault(a, len) - map.getOrDefault(b, len);
        });
        char[] res = new char[len];
        for(int i =0 ; i <len ;i++){
            res[i] = cs[i];
        }
        return String.valueOf(res);
    }
}

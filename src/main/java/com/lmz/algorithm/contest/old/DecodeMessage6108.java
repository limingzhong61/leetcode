package com.lmz.algorithm.contest.old;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage6108 {
    public String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(Character.isLetter(c)){
                if(map.containsKey(c)){
                    continue;
                }
                map.put(c,(char)(index++ +'a'));
            }

        }
        StringBuilder sb = new StringBuilder();
        for(var item : message.toCharArray()){
            if(Character.isLetter(item)){
                sb.append(map.get(item));
            }else {
                sb.append(item);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeMessage6108 decodeMessage6180 = new DecodeMessage6108();
        System.out.println(decodeMessage6180.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));

    }
}

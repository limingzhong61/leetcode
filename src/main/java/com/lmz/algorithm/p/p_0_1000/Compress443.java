package com.lmz.algorithm.p.p_0_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-08-05 11:48
 */
public class Compress443 {
    public int compress(char[] chars) {
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            char start = chars[i];
            int cnt = 1;
            int j = i;
            while(j + 1 < chars.length && chars[j+1] == start){
                cnt++;
                j++;
            }
            i = j;
            list.add(start);
            if(cnt > 1){
                for(char c : String.valueOf(cnt).toCharArray()){
                    list.add(c);
                }
            }
        }
        for(int i = 0; i < list.size(); i++){
            chars[i] = list.get(i);
        }
        return list.size();
    }
}

package com.lmz.leetcode.practice.p.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-01-29 10:25
 */
public class CountAsterisks2315 {
    public int countAsterisks(String s) {
        boolean first = false;
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == '|'){
                first = ! first;
            }else if(c == '*'){
                if(first){
                    first = true;
                    continue;
                }else{
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

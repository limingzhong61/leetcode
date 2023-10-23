package com.lmz.leetcode.practice.p.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-01-06 12:39
 */
public class CountEven2180 {
    public int countEven(int num) {
        int cnt = 0;
        for(int i = 2; i <= num; i++){
            char[] cs = String.valueOf(i).toCharArray();
            int sum = 0;
            for(char c : cs){
                sum += c - '0';
            }
            if(sum % 2 == 0){
                cnt++;
            }
        }
        return cnt;
    }
}

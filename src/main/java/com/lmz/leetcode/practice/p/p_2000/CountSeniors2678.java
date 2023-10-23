package com.lmz.leetcode.practice.p.p_2000;

/**
 * @author: limingzhong
 * @create: 2023-10-23 11:17
 */
public class CountSeniors2678 {
    class Solution {
        public int countSeniors(String[] details) {
            int cnt = 0;
            for(String s :details){
                if(Integer.valueOf(s.substring(11, 13)) > 60){
                    cnt++;
                    // System.out.println(s);
                }
            }
            return cnt;
        }
    }
}

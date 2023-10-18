package com.lmz.algorithm_practice.other.medium;

/**
 * @author: limingzhong
 * @create: 2023-05-11 15:49
 */
public class QueryString1016 {
    class Solution {
        public boolean queryString(String s, int n) {
            int len = s.length();
            char[] cs = s.toCharArray();
            boolean[] record = new boolean[n+1];
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = i; j < len; j++) {
                    sum = (sum << 1) + cs[j] - '0';
                    System.out.println(sum);
                    if(sum > n) break;
                    record[sum] = true;
                }
            }
            for(int i = 1; i <= n; i++){
                if(!record[i]) return false;
            }
            return false;
        }
    }
}

package com.lmz.algorithm_practice.contest.c326;

/**
 * @author: limingzhong
 * @create: 2023-01-01 10:30
 */
public class CountDigits {
    /**
     * num 的数位中不含 0
     */
    public int countDigits(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        //HashSet<Integer> set = new HashSet<>();
        //for(char c : cs){
        //    set.add(c -'a');
        //}
        int cnt = 0;
        for(var c : cs){
            int x = c -'0';
            if(num % x == 0){
                cnt++;
            }
        }
        return cnt;
    }
}

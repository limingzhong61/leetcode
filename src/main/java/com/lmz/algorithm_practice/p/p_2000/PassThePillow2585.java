package com.lmz.algorithm_practice.p.p_2000;

/**
 * @author: limingzhong
 * @create: 2023-09-26 12:11
 */
public class PassThePillow2585 {
    public int passThePillow(int n, int time) {
        n--;
        int cnt = time % n;
        int round = time / n;
        if(round % 2 == 0){
            return cnt+1;
        }else{
            return n - cnt;
        }
    }
}

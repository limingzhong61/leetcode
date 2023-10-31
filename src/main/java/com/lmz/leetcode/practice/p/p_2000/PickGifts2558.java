package com.lmz.leetcode.practice.p.p_2000;

import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-10-28 13:16
 */
public class PickGifts2558 {
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
            for(int x : gifts){
                pq.add(x);
            }
            long ans = 0;
            for(int i = 0; i < k; i++){
                int x = pq.poll();
                int y = (int) Math.ceil(Math.sqrt(x));
                if((long)y * y > x){
                    y = y-1;
                }
                // System.out.println(y);
                pq.add(y);
            }
            while(!pq.isEmpty()){
                ans += pq.poll();
            }
            return ans;
        }
    }
}

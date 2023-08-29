package com.lmz.algorithm.other.n1_1000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: limingzhong
 * @create: 2023-08-15 11:34
 */
public class RecentCounter933 {
    class RecentCounter {
        Deque<Integer> dq = new ArrayDeque<>();
        public RecentCounter() {

        }

        public int ping(int t) {
            dq.add(t);
            while(!dq.isEmpty() && dq.peekFirst() < t - 3000){
                dq.pollFirst();
            }
            return dq.size();
        }
    }
}

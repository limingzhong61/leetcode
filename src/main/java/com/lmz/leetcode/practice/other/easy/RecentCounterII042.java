package com.lmz.leetcode.practice.other.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-03-15 14:31
 */
public class RecentCounterII042 {
    class RecentCounter {
        Queue<Integer> queue = new ArrayDeque<>();
        public RecentCounter() {

        }

        public int ping(int t) {
            queue.add(t);
            while(queue.peek() < t - 3000){
                queue.poll();
            }
            return queue.size();
        }
    }

}

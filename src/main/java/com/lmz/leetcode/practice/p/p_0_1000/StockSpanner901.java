package com.lmz.leetcode.practice.p.p_0_1000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: limingzhong
 * @create: 2023-10-07 10:03
 */
public class StockSpanner901 {
    class StockSpanner {
        /**
         单调栈
         */
        // price,第几个加入 idx
        Deque<int[]> dq = new ArrayDeque<>();
        int idx = 0;
        public StockSpanner() {
            dq.addLast(new int[]{Integer.MAX_VALUE, 0});
        }

        public int next(int price) {

            while(!dq.isEmpty() && dq.peekLast()[0] <= price){
                dq.pollLast();
            }
            int lastIdx = dq.peekLast()[1];
            dq.addLast(new int[]{price, ++idx});
            return idx - lastIdx;
        }
    }
}

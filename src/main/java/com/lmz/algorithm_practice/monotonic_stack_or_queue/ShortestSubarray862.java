package com.lmz.algorithm_practice.monotonic_stack_or_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: codeofli
 * @create: 2022-10-26 13:31
 */
public class ShortestSubarray862 {
    /**
     * 单调队列
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {  // 计算前缀和
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int curSum = preSum[i];
            while(!deque.isEmpty() && curSum - preSum[deque.peekFirst()] >= k){ //优化一
                res = Math.min(res,i - deque.pollFirst());
            }
            while(!deque.isEmpty() && curSum <= preSum[deque.peekLast()]){ //优化二
                deque.pollLast();
            }
            deque.add(curSum);
        }
        return res;
    }
}

package com.lmz.algorithm.monotonic_stack_or_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-06-21 10:05
 */
public class MaxSlidingWindow239 {
    /**
     * 维护一个单调队列
     * 每次添加元素时，移除单调队列中 j < i && nums[j] < nums[i]的元素（为什么可以删除？已经j<i，i的有效性是大于i的）
     * 保存[val,idx] ,每次添加元素后，都移除 idx <= i - k 的元素
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列中只保留idx
        Deque<Integer> q = new ArrayDeque<>(k);
        for(int i = 0; i <k; i++){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){  // j < i && nums[j] < nums[i]
                q.pollLast();
            }
            q.addLast(i);
        }
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;
        ans[idx++] = nums[q.peekFirst()];
        for(int i = k; i < n; i++){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){  // j < i && nums[j] < nums[i]
                q.pollLast();
            }
            q.addLast(i);
            while(q.peekFirst() <= i-k){
                q.poll();
            }
            ans[idx++] = nums[q.peekFirst()];
        }
        return ans;
    }

    /**
     * 维护一个优先队列
     * 保存[val,idx] ,每次添加元素后，都移除 idx <= i - k 的元素
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,(a,b)-> {
            if(b[0] == a[0]){ //val相同，idx小的在前
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        for(int i = 0; i <k; i++){
            pq.add(new int[]{nums[i],i});
        }
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;
        ans[idx++] = pq.peek()[0];
        for(int i = k; i < n; i++){
            pq.add(new int[]{nums[i],i});
            while(pq.peek()[1] <= i-k){
                pq.poll();
            }
            ans[idx++] = pq.peek()[0];
        }
        return ans;
    }
}

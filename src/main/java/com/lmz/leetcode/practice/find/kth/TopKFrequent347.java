package com.lmz.leetcode.practice.find.kth;

import java.util.*;

public class TopKFrequent347 {



    /**
     * 利用优先队列
     * 小根堆，顶部为k个最大
     */
    public int[] topKFrequent(int[] nums, int k) {
        //value ,frequent
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : nums) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        for (var entry : map.entrySet()) {
            if (pq.size() == k) {
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        return Arrays.stream(pq.toArray(new int[0][0])).mapToInt(a -> a[0]).toArray();
    }

}

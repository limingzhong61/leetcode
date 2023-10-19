package com.lmz.leetcode.practice.other.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-05-14 11:10
 */
public class RearrangeBarcodes1054 {
    class Solution {
        /**
         * 核心思想就是每次选择当前数量最多的放进答案中，如何当前数量最多的和上一个选择的元素相同，
         * 那么就选择第二大的元素。 不停地重复这个过程。
         */
        public int[] rearrangeBarcodes(int[] barcodes) {
            int n = barcodes.length;
            Map<Integer, Integer> count = new HashMap<>();
            for (int b : barcodes) {
                if (!count.containsKey(b)) {
                    count.put(b, 0);
                }
                count.put(b, count.get(b) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                pq.offer(new int[]{entry.getValue(), entry.getKey()});
            }
            int[] res = new int[n];
            int[] poll = pq.poll();
            res[0] = poll[1];
            poll[0]--;
            pq.add(poll);
            for (int i = 1; i < n; i++) {
                int[] p = pq.poll();
                if (p[1] != res[i - 1]) {
                    res[i] = p[1];
                    p[0]--;
                } else {
                    int[] q = pq.poll();
                    res[i] = q[1];
                    q[0]--;
                    if (q[0] > 0) pq.add(q);
                }
                if (p[0] > 0) pq.add(p);
            }
            return res;
        }
    }
}

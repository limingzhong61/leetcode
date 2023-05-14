package lmz.leetcode.other.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-05-14 11:10
 */
public class RearrangeBarcodes1054 {
    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int n =barcodes.length;
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
            
            return res;
        }
    }
}

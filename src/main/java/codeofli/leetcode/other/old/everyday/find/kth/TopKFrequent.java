package codeofli.leetcode.other.old.everyday.find.kth;

import java.util.*;

public class TopKFrequent {
    /**
     * 利用优先队列
     * 小根堆，顶部为k个最大
     */
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.frequent - b.frequent);
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : nums) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        for (var entry : map.entrySet()) {
            if (heap.size() == k) {
                if (entry.getValue() > heap.peek().frequent) {
                    heap.poll();
                    heap.add(new Pair(entry.getKey(), entry.getValue()));
                }
            } else {
                heap.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        return Arrays.stream(heap.toArray(new Pair[0])).mapToInt(pair -> pair.value).toArray();
    }

    class Pair {
        int value;
        int frequent;

        Pair(int value, int frequent) {
            this.value = value;
            this.frequent = frequent;
        }
    }
}

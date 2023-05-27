package lmz.algorithm.other.easy.old;

import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    /**
     * 使用优先队列,大根堆
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : stones) {
            pq.add(x);
        }
        while (pq.size() > 1) {
            int one = pq.poll();
            int two = pq.poll();
            if (one != two) { //相等，直接两个都粉碎，不添加
                pq.add(one - two);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}

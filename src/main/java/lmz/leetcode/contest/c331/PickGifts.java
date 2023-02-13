package lmz.leetcode.contest.c331;

import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-02-05 10:30
 */
public class PickGifts {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            pq.add(gift);
        }
        long res = 0;
        for (int i = 0; pq.size() > 0 && i < k; i++) {
            int val = pq.poll();
            double floor = Math.floor(Math.sqrt(val));
            pq.add((int) floor);
            System.out.println(floor);
        }
        while(!pq.isEmpty()){
            res += pq.poll();
        }
        return res;
    }
}

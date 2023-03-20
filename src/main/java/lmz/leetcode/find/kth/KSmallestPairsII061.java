package lmz.leetcode.find.kth;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-03-20 11:09
 */
public class KSmallestPairsII061 {
    /**
     * 加减溢出
     * -109 <= nums1[i], nums2[i] <= 109
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (int) ((long) b[0] + b[1] - a[0] - a[1]));
        int x = nums1[0];
        int y = nums2[0];
        for (int i = 0; i < nums2.length; i++) {
            if(pq)
            pq.add()
        }
    }
}

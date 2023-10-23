package com.lmz.leetcode.practice.p.old.k_pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-05-28 11:39
 */
public class KSmallestPairs {

    /*去重+小根堆
        利用堆减低复杂度
        i - 1,j -> (i,j) 且 （i,j-1) ->(i,j) ;则 (i,j)->(i+1,j)和(i,j+1)，
        因此可以**通过约定（i,j）只能到（i+1，j)，**但是这样从（0,0）开始只会得到（1，0），（2,0）。。。;因此需要将（0,1,），（0,2）添加到小根堆中。
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(nums2.length, k); i++) {
            pq.add(new int[]{nums1[0] + nums2[i], 0, i});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < k) {
            int[] poll = pq.poll();
            int i = poll[1];
            int j = poll[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (i + 1 < nums1.length)
                pq.add(new int[]{nums1[i+1] + nums2[j], i + 1, j});
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, (a, b) -> b.get(0) - a.get(0));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (pq.size() >= k) {
                    if (nums1[i] + nums2[j] < pq.peek().get(0)) {
                        pq.poll();
                        pq.add(List.of(nums1[i] + nums2[j], nums1[i], nums2[j]));
                    }
                } else {
                    pq.add(List.of(nums1[i] + nums2[j], nums1[i], nums2[j]));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(k);
        while (!pq.isEmpty()) {
            res.add(List.of(pq.peek().get(1), pq.poll().get(2)));
        }
        Collections.reverse(res);
        return res;
    }
}

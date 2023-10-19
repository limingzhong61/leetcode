package com.lmz.leetcode.practice.other.old.k_pairs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-05-28 11:10
 */
public class KthSmallest1439 {
    /**
     * 逐个枚举，枚举数量过多后，只保留前k个
     * 小根堆优化：每次取两个row合并为k个
     */
    public int kthSmallest(int[][] mat, int k) {
        int[] a = new int[]{0};
        for (var row : mat) {
            a = kSmallestPairs(a, row, k);
            System.out.println(Arrays.toString(a));
        }
        return a[k - 1];
    }

    /**
     * // 373. 查找和最小的 K 对数字
     * 去重+小根堆
     * 利用堆减低复杂度
     * i - 1,j -> (i,j) 且 （i,j-1) ->(i,j) ;则 (i,j)->(i+1,j)和(i,j+1)，
     * 因此可以**通过约定（i,j）只能到（i+1，j)，**但是这样从（0,0）开始只会得到（1，0），（2,0）。。。;因此需要将（0,1,），（0,2）添加到小根堆中。
     */
    public int[] kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> a[0] - b[0]);
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < Math.min(nums2.length, k); i++) {
            pq.add(new int[]{nums1[0] + nums2[i], 0, i});
        }
        int[] ans = new int[Math.min(k, n * m)];
        int len = 0;
        while (!pq.isEmpty() && len < k) {
            int[] poll = pq.poll();
            int i = poll[1];
            int j = poll[2];
            ans[len++] = poll[0];
            if (i + 1 < nums1.length)
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
        }
        return ans;
    }

    /**
     * 逐个枚举，枚举数量过多后，只保留前k个
     */
    public int kthSmallest2(int[][] mat, int k) {
        int[] a = new int[]{0};
        for (var row : mat) {
            int[] b = new int[a.length * row.length];
            int i = 0;
            for (var x : a) {
                for (var y : row) {
                    b[i++] = x + y;
                }
            }
            Arrays.sort(b);
            if (b.length > k) {
                b = Arrays.copyOfRange(b, 0, k);
            }
            a = b;
        }
        return a[k - 1];
    }
}

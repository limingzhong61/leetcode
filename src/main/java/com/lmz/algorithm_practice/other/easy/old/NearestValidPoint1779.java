package com.lmz.algorithm_practice.other.easy.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class NearestValidPoint1779 {
    /**
     * 注：返回最小的下标
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int distance = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (x == point[0]) {
                int dis = Math.abs(point[1] - y);
                if (distance > dis) {
                    distance = dis;
                    minIndex = i;
                }

            } else if (y == point[1]) {
                int dis = Math.abs(point[0] - x);
                if (distance > dis) {
                    distance = dis;
                    minIndex = i;
                }
            }
        }
        return distance == Integer.MAX_VALUE ? -1 : minIndex;
    }

    public static void main(String[] args) {
        NearestValidPoint1779 nearestValidPoint = new NearestValidPoint1779();
        System.out.println(nearestValidPoint.nearestValidPoint(3, 4, TransformUtil.toIntMatrix("[[1,2],[3,1],[2,4],[2,3],[4,4]]")));
        System.out.println(nearestValidPoint.nearestValidPoint(3, 4, TransformUtil.toIntMatrix("[[1,2],[3,1],[2,4],[2,3],[4,4]]")) == 2);

    }
}

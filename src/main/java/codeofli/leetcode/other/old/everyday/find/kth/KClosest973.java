package codeofli.leetcode.other.old.everyday.find.kth;

import codeofli.my.leetcode.TransformUtil;

import java.util.*;

public class KClosest973 {
    /**
     * 快速选择
     */
    public int[][] kClosest(int[][] points, int k) {
        partition(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    Random rand = new Random();

    private void partition(int[][] points, int low, int high, int k) {
        if (low > high) {
            return;
        }
        int pivotId = low + rand.nextInt(high - low + 1);
        int pivot = dist(points, pivotId);
        swap(points, pivotId, low); //交换随机的点和low
        int preLow = low, preHigh = high;
        while (low < high) {
            while (low < high && pivot <= dist(points, high)) {
                high--;
            }
            while (low < high && pivot >= dist(points, low)) {
                low++;
            }
            swap(points, high, low);
        }
        swap(points, low, preLow); //交换枢轴和low点
        if (low == k) {
            return;
        } else if (low > k) {
            partition(points, preLow, low - 1, k); //k更小
        } else {
            partition(points, low + 1, preHigh, k); //
        }
    }

    private int dist(int[][] points, int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    private void swap(int[][] points, int high, int low) {
        int[] temp = points[high];
        points[high] = points[low];
        points[low] = temp;
    }

    /**
     * 大根堆，堆顶为第k小
     */
    public int[][] kClosest1(int[][] points, int k) {
        //    1 <= k <= points.length <= 104
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(points[i], (points[i][0] * points[i][0] + points[i][1] * points[i][1])));
        }
        for (int i = k; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek().distance) {
                pq.poll();
                pq.add(new Pair(points[i], dist));
            }
        }
        List<int[]> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().point);
        }
        return list.toArray(new int[0][0]);
    }

    class Pair {
        int[] point;
        int distance;

        Pair(int[] point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        KClosest973 kClosest973 = new KClosest973();
        //System.out.println(Arrays.deepToString(kClosest973.kClosest(TransformUtil.toIntMatrix("[[1,3],[-2,2]]\n"), 1)));
        //System.out.println(Arrays.deepToString(kClosest973.kClosest(TransformUtil.toIntMatrix("[[3,3],[5,-1],[-2,4]]\n"), 2)));
        System.out.println(Arrays.deepToString(kClosest973.kClosest(TransformUtil.toIntMatrix("[[0,1],[1,0]]\n"), 2)));
    }
}

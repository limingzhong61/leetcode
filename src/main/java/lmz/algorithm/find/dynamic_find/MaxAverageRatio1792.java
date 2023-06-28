package lmz.algorithm.find.dynamic_find;

import java.util.PriorityQueue;

public class MaxAverageRatio1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            double x = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double y = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(y, x);
        });

        for (var x : classes) {
            pq.add(new double[]{x[0], x[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] poll = pq.poll();
            pq.add(new double[]{poll[0] + 1, poll[1] + 1});
        }

        double res = 0;
        int size = pq.size();
        while (!pq.isEmpty()) {
            double[] poll = pq.poll();
            // System.out.printf("%f,%f\n", poll[0], poll[1]);
            res += (double) poll[0] / poll[1];
        }

        return res / size;
    }
}

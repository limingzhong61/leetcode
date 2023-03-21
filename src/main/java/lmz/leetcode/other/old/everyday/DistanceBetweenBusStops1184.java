package lmz.leetcode.other.old.everyday;

import lmz.my.leetcode.TransformUtil;

public class DistanceBetweenBusStops1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        //1 <= n <= 10^4
        int n = distance.length;
        int forward = 0,backward = 0;
        for (int i = start; i != destination; i = (i + 1) % n) {
            forward += distance[i];
        }
        // backward 等价于从destination到start
        for (int i = destination; i % n != start;i = (i +1) % n ) {
            backward += distance[i];
        }
        return Math.min(forward,backward);
    }

    public static void main(String[] args) {
        DistanceBetweenBusStops1184 distanceBetweenBusStops1184 = new DistanceBetweenBusStops1184();
        testCase(distanceBetweenBusStops1184, 1, 1);
        testCase(distanceBetweenBusStops1184, 2, 3);
        testCase(distanceBetweenBusStops1184, 3, 4);
    }

    private static void testCase(DistanceBetweenBusStops1184 distanceBetweenBusStops1184, int destination, int x) {
        System.out.println(distanceBetweenBusStops1184.distanceBetweenBusStops(TransformUtil.toIntArray("[1,2,3,4]"), 0, destination));
        System.out.println(distanceBetweenBusStops1184.distanceBetweenBusStops(TransformUtil.toIntArray("[1,2,3,4]"), 0, destination) == x);
    }
}

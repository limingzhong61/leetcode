package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] task = new int[n][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[0] - b[1];
            }
            return a[0] - b[0];
        });
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            pq.add(new int[]{start, end, i + 1});
            treeSet.add(start);
        }
        int startTime = 0;
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            startTime = Math.max(t[0], startTime);
            int endTime = startTime + t[1];
            Integer higher = treeSet.higher(startTime);
            if (higher != null) {
                if (endTime <= higher) {
                    System.out.printf("%d,%d\n", t[2], endTime);
                } else {
                    t[1] -= higher - t[0];
                    t[0] = higher;
                    endTime = higher;
                    pq.add(t);
                }
            } else {
                System.out.printf("%d,%d\n", t[2], endTime);
            }
            startTime = endTime;
        }
    }
}

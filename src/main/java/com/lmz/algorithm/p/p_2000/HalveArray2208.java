package com.lmz.algorithm.p.p_2000;

import java.util.PriorityQueue;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-07-25 9:43
 */
public class HalveArray2208 {
    /**
     * 使用TreeMap
     */
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> (int) (b-a));
        for(int x : nums){
            pq.add((double) x);
        }
        int sum = IntStream.of(nums).sum();
        double half = sum / 2.0;
        double remove = 0;
        int cnt = 0;
        while(half > remove && !pq.isEmpty()){
            cnt++;
            double x = pq.poll() / 2.0;
            remove += x;
            pq.add(x);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Double x = Double.valueOf(1.0);
        Double y = 1.0;
        x.equals(y);
        System.out.println(x == y);
    }
}

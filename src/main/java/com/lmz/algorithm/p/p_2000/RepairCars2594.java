package com.lmz.algorithm.p.p_2000;

import com.lmz.my.leetcode.TransformUtil;

/**
 * @author: limingzhong
 * @create: 2023-09-07 9:33
 */
public class RepairCars2594 {
    /**
     * 最大最小值问题
     */
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = (long) 1e14 + 1;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long cnt = 0;
            for (int rank : ranks) {
                cnt += (long) Math.sqrt(mid / rank);
            }
            if (cnt >= cars) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        RepairCars2594 repairCars2594 = new RepairCars2594();
        System.out.println(repairCars2594.repairCars(TransformUtil.toIntArray("[4,2,3,1]"), 10));
        System.out.println(repairCars2594.repairCars(TransformUtil.toIntArray("[4,2,3,1]"), 10) == 16);

        System.out.println(repairCars2594.repairCars(TransformUtil.toIntArray("[4,2,3,1]"), 10));
        System.out.println(repairCars2594.repairCars(TransformUtil.toIntArray("[4,2,3,1]"), 10) == 16);
    }
}

package com.lmz.algorithm_practice.graph.traverse.bfs;

import java.util.HashSet;
import java.util.Locale;

public class CanMeasureWater365 {
    /**
     * 模拟不断从小杯子里往大杯子里到，保存小杯子能得到的新的剩余值remain，不断将targetCapacity的值降为0
     * 如果在没有降为0之前出现重复的剩余值remain，则说明不能成功
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(targetCapacity > jug1Capacity+jug2Capacity){
            return false;
        }
        int maxCapacity = Math.max(jug1Capacity,jug2Capacity);
        int minCapacity = Math.min(jug1Capacity,jug2Capacity);
        int max = maxCapacity,min = minCapacity;
        HashSet<Integer> set = new HashSet<>();

        while(targetCapacity != 0){
            int remain = max % min;
            remain = min - remain;
            if(set.contains(remain)){ //已经不能得到新的值了
                break;
            }
            set.add(remain);
            max = maxCapacity - remain;
            targetCapacity %= remain;
        }
        return targetCapacity == 0;
    }

    public static void main(String[] args) {
        CanMeasureWater365 canMeasureWater365 = new CanMeasureWater365();

        testCase(canMeasureWater365, 3, 5, 4, true);

        testCase(canMeasureWater365, 2, 6, 5, false);
        testCase(canMeasureWater365, 1, 2, 3, true);
        testCase(canMeasureWater365, 6, 9, 1, false);
        testCase(canMeasureWater365, 1, 1, 12, false);
    }

    private static void testCase(CanMeasureWater365 canMeasureWater365, int i, int i2, int i3, boolean b) {
        System.out.println(canMeasureWater365.canMeasureWater(i, i2, i3));
        System.out.println(String.valueOf(
                canMeasureWater365.canMeasureWater(i, i2, i3) == b).toUpperCase(Locale.ROOT));
    }
}

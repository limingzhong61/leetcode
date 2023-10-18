package com.lmz.algorithm_practice.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum006II {
    /**
     * 已经升序+存在且只存在一对符合条件的数字
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        return new int[0];
    }
}

package com.lmz.algorithm_practice.other.old.primary.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    /**
     * my:
     * 构建HashMap<val,index>,如果存在HashMap.get(target-val)则有
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int minus = target-nums[i];
            if(map.containsKey(minus)){
                return new int[]{map.get(minus),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}

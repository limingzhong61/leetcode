package codeofli.leetcode.find.kth.easy;

import java.util.*;

public class FrequencySort1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            numList.add(x);
        }
        Collections.sort(numList,(a,b) ->{
            if(map.get(a) == map.get(b)){
                return b - a;
            }
            return map.get(a) - map.get(b);
        });
        for(int i = 0; i < nums.length; i++){
            nums[i] = numList.get(i);
        }
        return nums;
    }
}

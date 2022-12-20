package lmz.leetcode.contest.old.c84;

import java.util.HashMap;
import java.util.Map;

public class CountBadPairs6142 {
    public long countBadPairs(int[] nums) {
        //1 <= nums.length <= 105
        long n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i= 0; i < n; i++){
            int g = nums[i] - i;
            map.put(g,map.getOrDefault(g,0)+1);
        }
        long equalsPair = 0;
        for(var entry : map.entrySet()){
            Integer value = entry.getValue();
            //value中取2
            long pairCnt = (long) value * (value -1) / 2;
            equalsPair += pairCnt;
        }
        long totalPair = n *(n-1) / 2;
        // System.out.println(equalsPair);
        return totalPair - equalsPair;
    }
}

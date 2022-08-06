package codeofli.leetcode.contest.test;

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
        long equlesPair = 0;
        for(var entry : map.entrySet()){
            Integer value = entry.getValue();
            //value中取2
            long pairCnt = (long) value * (value -1) / 2;
            equlesPair += pairCnt;
        }
        long totalPair = n *(n-1) / 2;
        // System.out.println(equlesPair);
        return totalPair - equlesPair;
    }

    //public long countBadPairs(int[] nums) {
    //    //1 <= nums.length <= 105
    //    int n = nums.length;
    //    int cnt = 0;
    //    for (int i = 0; i < n; i++) {
    //        for (int j = i + 1; j < n; j++) {
    //            if(nums[j] - nums[i] != j - i){
    //                cnt++;
    //            }
    //        }
    //    }
    //    return cnt;
    //}
}

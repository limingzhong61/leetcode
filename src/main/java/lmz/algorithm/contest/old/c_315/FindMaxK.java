package lmz.algorithm.contest.old.c_315;

import java.util.HashSet;
import java.util.Set;

public class FindMaxK {
    //nums[i] != 0
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = -1;
        for(int x : nums){
            set.add(x);
            if(set.contains(-x)){
                res = Math.max(res,Math.abs(x));
            }
        }
        return res;
    }
}

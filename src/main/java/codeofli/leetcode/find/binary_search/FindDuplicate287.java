package codeofli.leetcode.find.binary_search;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FindDuplicate287 {
    /**
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }
}

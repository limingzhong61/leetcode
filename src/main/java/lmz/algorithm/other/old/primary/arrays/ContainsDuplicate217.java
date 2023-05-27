package lmz.algorithm.other.old.primary.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)){
                return true;
            }
        }
        return false;
    }
}

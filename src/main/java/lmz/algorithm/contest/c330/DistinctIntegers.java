package lmz.algorithm.contest.c330;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-01-29 10:31
 */
public class DistinctIntegers {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int size = 0;
        while (set.size() != size) {
            size = set.size();
            Set<Integer> newSet = new HashSet<>();
            for(var  x : set){
                newSet.add(x);
                for (int i = 2; i <= x; i++) {
                    if(x % i == 1){
                        newSet.add(i);
                    }
                }
            }
            set = newSet;
        }
        return  set.size();
    }
}

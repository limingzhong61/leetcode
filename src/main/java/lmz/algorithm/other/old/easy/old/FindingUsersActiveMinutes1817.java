package lmz.algorithm.other.old.easy.old;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-01-20 9:43
 */
public class FindingUsersActiveMinutes1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        var res = new int[k];

        Map<Integer, Set<Integer>> idMap = new HashMap<>();
        for(int[] log :logs){
            Set<Integer> set = idMap.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            idMap.put(log[0],set);
        }

        for(var set : idMap.values()){
            res[set.size() -1]++;
        }
        return res;
    }
}

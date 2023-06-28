package lmz.algorithm.contest.old.c312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {
    /**
     * heights 中的所有值互不相同
     */
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String>  map = new HashMap<>();
        int n = names.length;
        Pair<String,Integer>[] pairs= new Pair[n];
         for(int i = 0; i < names.length; i++){
            map.put(i,names[i]);
            pairs[i] = new Pair<>(names[i],heights[i]);
        }
        Arrays.sort(pairs,(a,b)->{
            return b.val2 - a.val2;
        });
        for(int i = 0; i < names.length; i++){
            names[i] = pairs[i].val1;
        }
        return names;
    }

    /**
     * 通用泛型Pair类型
     */
    public class Pair<V1, V2> {
        public V1 val1;
        public V2 val2;
        public Pair() {}

        public Pair(V1 val1, V2 val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
}

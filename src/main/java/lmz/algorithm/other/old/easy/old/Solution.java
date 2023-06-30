package lmz.algorithm.other.old.easy.old;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

class Solution {
    TreeMap<Integer,Integer> map;
    int sum  = 0;
    Random random = new Random();
    public Solution(int[] w) {
        map = new TreeMap<>();
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            map.put(sum,i);
        }
    }

    public int pickIndex() {
        int next = random.nextInt(sum);
        Map.Entry<Integer, Integer> entry = map.ceilingEntry(next);
        return  entry.getValue();
    }
}

package lmz.leetcode.other.easy.old;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairs2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int pairCnt = 0, remainder = 0;
        for (var cnt : map.values()) {
            pairCnt += cnt / 2;
            remainder += cnt % 2;
        }
        return new int[]{pairCnt, remainder};
    }
}

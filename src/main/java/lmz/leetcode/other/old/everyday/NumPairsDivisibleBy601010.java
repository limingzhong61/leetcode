package lmz.leetcode.other.old.everyday;

import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-05-07 10:41
 */
public class NumPairsDivisibleBy601010 {
    class Solution {
        /**
         * 取余+hash计数
         */
        public int numPairsDivisibleBy60(int[] time) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (var x : time) {
                x %= 60;
                // System.out.printf("%d,%d,%d\n",x,60 - x == 60 ? 0 : 60 - x,map.getOrDefault(60 - x == 60 ? 0 : x, 0));
                res += map.getOrDefault(60 - x == 60 ? 0 : 60 - x, 0);
                map.put(x, map.getOrDefault(x, 0) + 1);
                // System.out.printf("%d,%d---\n",x, map.getOrDefault(x, 0));
            }
            return res;
        }
    }
}

package codeofli.leetcode.other.primary.arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {
    /**
     * my:
     * HashMap
     * 时间复杂度:O(n)
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            int cnt = map.get(x) == null ? 0 : map.get(x);
            map.put(x,cnt+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * leetcode:
     * 异或解法:
     *重点：a^0=a,a^a=0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int i : nums){
            single ^= i;
        }
        return single;
    }
}

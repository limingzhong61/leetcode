package codeofli.leetcode.contest.c1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: codeofli
 * @create: 2022-10-29 23:42
 */
public class DestroyTargets {
    public int destroyTargets(int[] nums, int space) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for(int i = 0; i < n; i++){
            if(nums[i] > space){
                nums[i] -= nums[i] / space * space;
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int max = 0,res = nums[0],key = 0;
        for(var entry :map.entrySet()){
            if(entry.getValue() >= max){
                max = entry.getValue();
                key = Math.min(key,entry.getKey());
            }
        }
        Arrays.sort(copy);
        for(int i = 0; i < n; i++){
            if(copy[i] > space && copy[i] - copy[i] / space * space == key){
                return copy[i];
            }
            if(nums[i] == key){
                return copy[i];
            }
        }
        return res;
    }
}

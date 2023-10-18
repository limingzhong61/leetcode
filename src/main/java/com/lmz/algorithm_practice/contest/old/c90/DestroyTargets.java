package com.lmz.algorithm_practice.contest.old.c90;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
        int max = 0;
        HashSet<Integer> keySet = new HashSet<>();
        for(var entry :map.entrySet()){
            max = Math.max(max,entry.getValue());
        }
        for(var entry :map.entrySet()){
            if(entry.getValue() == max){
                keySet.add(entry.getKey());
            }
        }
        int minRes = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(keySet.contains(nums[i])){
                minRes =Math.min(minRes,copy[i]);
            }
        }
        return minRes;
    }

    public static void main(String[] args) {
        DestroyTargets destroyTargets = new DestroyTargets();
        System.out.println(destroyTargets.destroyTargets(TransformUtil.toIntArray("[4,5,5,2,1]"), 4));
    }
}

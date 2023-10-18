package com.lmz.algorithm_practice.contest.old.c_1015;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MinimizeArrayValue {
    public int minimizeArrayValue(int[] nums) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            add(nums, treeMap, i);
        }
        while (true) {
            var entry = treeMap.lastEntry();
            List<Integer> list = entry.getValue();
            Integer key = entry.getKey();
            boolean success = true;
            ArrayList<Integer> nextKeyIdxs = new ArrayList<>();
            for (int idx : list) {
                if (idx == 0) { // 没法操作
                    return key;
                }
                if (nums[idx - 1] == key) { // 没法操作使其变得更大
                    nextKeyIdxs.add(idx - 1);
                    continue;
                }
                // 删除之前的记录
                List<Integer> list3 = treeMap.getOrDefault(nums[idx - 1], new ArrayList<>());
                list3.remove(Integer.valueOf(idx - 1));
                if (list3.size() == 0) {
                    treeMap.remove(nums[idx - 1]);
                } else {
                    treeMap.put(nums[idx - 1], list3);
                }
                nums[idx]--;
                nums[idx - 1]++;
                add(nums, treeMap, idx);
                if(nums[idx - 1] != key){ //小于key才加入，
                    add(nums, treeMap, idx - 1);
                }else {
                    nextKeyIdxs.add(idx - 1);
                }
            }
            if(nextKeyIdxs.isEmpty()){
                treeMap.remove(key);
            }else{
                treeMap.put(key,nextKeyIdxs);
            }
        }
    }

    private static void add(int[] nums, TreeMap<Integer, List<Integer>> treeMap, int idx) {
        List<Integer> list3 = treeMap.getOrDefault(nums[idx], new ArrayList<>());
        list3.add(idx);
        treeMap.put(nums[idx], list3);
    }

    public static void main(String[] args) {
        MinimizeArrayValue minimizeArrayValue = new MinimizeArrayValue();
        System.out.println(minimizeArrayValue.minimizeArrayValue(TransformUtil.toIntArray("[3,7,1,6]")));
        System.out.println(minimizeArrayValue.minimizeArrayValue(TransformUtil.toIntArray("[13,13,20,0,8,9,9]")));
        System.out.println(minimizeArrayValue.minimizeArrayValue(TransformUtil.toIntArray("[13,13,20,0,8,9,9]")) == 16);
        System.out.println(minimizeArrayValue.minimizeArrayValue(TransformUtil.toIntArray("[6,9,3,8,14]")));
        System.out.println(minimizeArrayValue.minimizeArrayValue(TransformUtil.toIntArray("[6,9,3,8,14]")) == 8);
    }
}

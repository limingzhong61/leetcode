package com.lmz.leetcode.practice.p.old.everyday;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindFrequentTreeSum508 {
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        recur(root);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int maxCnt = 0;
        for(var entry : entries){
            maxCnt = Math.max(maxCnt,entry.getValue());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(var entry : entries){
            if(maxCnt == entry.getValue()){
                list.add(entry.getKey());
            }
        }
        int[] nums = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

    private int recur(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = recur(root.left) + recur(root.right) + root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }

    public static void main(String[] args) {
        FindFrequentTreeSum508 findFrequentTreeSum508 = new FindFrequentTreeSum508();
        //findFrequentTreeSum508.findFrequentTreeSum()
    }
}























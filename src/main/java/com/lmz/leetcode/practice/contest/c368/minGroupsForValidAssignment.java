package com.lmz.leetcode.practice.contest.c368;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-10-22 10:51
 */
public class minGroupsForValidAssignment {
    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int x : nums) {
            counter.put(x, counter.getOrDefault(x, 0) + 1);
        }

        List<Integer> values = counter.values().stream().toList();
        int minCount = Integer.MAX_VALUE;
        int maxCount = Integer.MIN_VALUE;
        for (int x : values) {
            minCount = Math.min(x, minCount);
            maxCount = Math.max(x, maxCount);
        }

        int left = 1, right = maxCount + 1;
        int ans = Integer.MAX_VALUE;
        for (int i = right; i >= 2; i--) {
            int groupCnt = 0;

            // i , i + 1
            left = i - 1;
            right = i;
            for (int x : values) {
                int next1 = x / left;
                if(x % left != 0 && x % left != 1){
                    next1 = Integer.MAX_VALUE;
                }else{
                    if(x == 1) next1++;
                }

                int next2 = x / right;
                if(x % right != 0 && x % right != left){
                    next2 = Integer.MAX_VALUE;
                }else{
                   if(x % right == left)  next2++;
                }
                if(next1 == Integer.MAX_VALUE && next2 == Integer.MAX_VALUE) {
                    groupCnt = -1;
                    break;
                }
                groupCnt += Math.min(next2,next1);
            }

            //groupCnt = 0;
            //// i , i + 1
            //left = i;
            //right = i + 1;
            //for (int x : values) {
            //    int next1 = x / left;
            //    if(x % left != 0 || x % left != 1){
            //        next1 = Integer.MAX_VALUE;
            //    }else{
            //        if(x == 1) next1++;
            //    }
            //
            //    int next2 = x / right;
            //    if(x % right != 0 || x % right != left){
            //        next2 = Integer.MAX_VALUE;
            //    }else{
            //        next2++;
            //    }
            //    if(next1 == Integer.MAX_VALUE && next2 == Integer.MAX_VALUE) {
            //        groupCnt = -1;
            //        break;
            //    }
            //    groupCnt += Math.min(next2,next1);
            //}
            if (groupCnt != -1) {
                ans = Math.min(groupCnt, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        minGroupsForValidAssignment minGroupsForValidAssignment = new minGroupsForValidAssignment();
        System.out.println(minGroupsForValidAssignment.minGroupsForValidAssignment(TransformUtil.toIntArray("[10,10,10,3,1,1]")));
        System.out.println(minGroupsForValidAssignment.minGroupsForValidAssignment(TransformUtil.toIntArray("[3,2,3,2,3]")));
        System.out.println(minGroupsForValidAssignment.minGroupsForValidAssignment(TransformUtil.toIntArray("[1,1,1,3,1,2,2,2,3]")));
    }
}

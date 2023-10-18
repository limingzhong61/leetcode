package com.lmz.algorithm_practice.other.old.everyday;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class ArrayNesting565 {
    /**
     * 用hashset判断是否环结束，即可
     * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
     */
    public int arrayNesting(int[] nums) {
        //N是[1, 20,000]之间的整数。
        int len = nums.length;
        boolean[] set = new boolean[len];
        int max = 0;
        for(int i = 0; i < len ; i++){
            int cnt = 0;
            int k = i;
            while(!set[nums[k]]){
                cnt++;
                set[nums[k]] = true; //标记访问
                k = nums[k];
            }
            max = Math.max(max,cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayNesting565 arrayNesting565 = new ArrayNesting565();
        System.out.println(arrayNesting565.arrayNesting(TransformUtil.toIntArray(" [5,4,0,3,1,6,2]")));
        System.out.println(arrayNesting565.arrayNesting(TransformUtil.toIntArray(" [5,4,0,3,1,6,2]")) == 4);
    }
}

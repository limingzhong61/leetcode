package codeofli.leetcode.contest.c302;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.Arrays;

public class MinOperations6122 {
    /**
     * 暴力，估计不行n*n
     */
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            boolean flag = true;
            for(int j = 0; j < numsDivide.length; j++){
                if(numsDivide[j] % nums[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return res;
            }
            res++;
            int nowVal = nums[i];
            for(; i+1 < nums.length; i++){
                if(nums[i+1] == nowVal){
                    res++;
                }else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinOperations6122 minOperations6122 = new MinOperations6122();
        System.out.println(minOperations6122.minOperations(StringTransformUtil.toIntArray("[2,3,2,4,3]"),
                StringTransformUtil.toIntArray("[9,6,9,3,15]")));
        System.out.println(minOperations6122.minOperations(StringTransformUtil.toIntArray("[4,3,6]"),
                StringTransformUtil.toIntArray("[8,2,6,10]")));
    }
}

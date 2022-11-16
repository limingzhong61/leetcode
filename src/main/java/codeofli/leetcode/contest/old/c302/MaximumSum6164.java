package codeofli.leetcode.contest.old.c302;

import codeofli.my.leetcode.TransformUtil;

import java.util.HashMap;
import java.util.Map;

public class MaximumSum6164 {
    public int maximumSum(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // <digitSum,maxVal>
        int maxSum = -1;
        for(int i = 0; i < len; i++){
            int digitSum = getNumberDigitSum(nums[i]);
            if(map.containsKey(digitSum)){
                maxSum = Math.max(maxSum,nums[i] + map.get(digitSum));
                if(nums[i] > map.get(digitSum)){
                    map.put(digitSum,nums[i]);
                }
            }else{
                map.put(digitSum,nums[i]);
            }
        }
        return maxSum;
    }
    public static int getNumberDigitSum(int num){
        int sum = 0;
        //因为0不计入统计，故不用处理num == 0的情况
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumSum6164 maximumSum6164 = new MaximumSum6164();
        System.out.println(maximumSum6164.maximumSum(TransformUtil.toIntArray("[18,43,36,13,7]")));
        System.out.println(maximumSum6164.maximumSum(TransformUtil.toIntArray("[10,12,19,14]")));
    }
}

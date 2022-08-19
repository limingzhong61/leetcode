package codeofli.leetcode.data_structure.array;

public class RunningSum1480 {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

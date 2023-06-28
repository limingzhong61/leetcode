package lmz.algorithm.two_pointer;

import java.util.Arrays;

public class ArrayPairSum561 {
    /**
     * my: 排序后偶数之和
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }
}

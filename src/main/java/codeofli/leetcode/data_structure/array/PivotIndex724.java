package codeofli.leetcode.data_structure.array;

import java.util.Arrays;

public class PivotIndex724 {
    /**
     * leetcode:
     * 左求和*2+中心索引值 = 总和
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int length = nums.length;
        int[] rightSum = new int[length];
        int leftSum = 0;
        for (int i = 0; i < length; i++) {
            if (leftSum * 2 + nums[i] == total) { //左求和*2+中心索引值 = 总和
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int length = nums.length;
        int[] rightSum = new int[length];
        rightSum[length-1] = nums[length-1];
        for(int i = length-2; i >= 0; i--){
            rightSum[i] = rightSum[i+1]+ nums[i];
        }
        int leftSum = 0;
        for(int i = 0; i < length; i++){
            leftSum += nums[i];
            if(leftSum == rightSum[i]){ //左边和右边和相同 + 中间结点也相同
                return i;
            }
        }
        return -1;
    }
}

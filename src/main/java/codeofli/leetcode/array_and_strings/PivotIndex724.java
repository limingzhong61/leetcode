package codeofli.leetcode.array_and_strings;

public class PivotIndex724 {

    public int pivotIndex(int[] nums) {
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

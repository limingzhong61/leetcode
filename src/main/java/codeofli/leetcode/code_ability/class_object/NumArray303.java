package codeofli.leetcode.code_ability.class_object;

public class NumArray303 {
    class NumArray {
        int[] nums;
        // sums[i] = nums[0,i-1]
        int[] sums;
        public NumArray(int[] nums) {
            this.nums = nums;
            if(nums.length  == 0){
                return;
            }
            this.sums = new int[nums.length+1];
            sums[1] = nums[0];
            for(int i = 2; i <= nums.length; i++){
                sums[i] += sums[i-1] + nums[i-1];
            }
        }

        /**
         * 前缀和
         */
        public int sumRange(int left, int right) {
            return sums[right+1] - sums[left];
        }
    }
}

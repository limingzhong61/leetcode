package codeofli.leetcode.contest.old.c304;

public class MinimumOperations6132 {
    /**
     * 模拟
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */
    public int minimumOperations(int[] nums) {
        int cntZero = 0;
        int res = 0;
        while(cntZero != nums.length){
            cntZero = 0;
            int min = Integer.MAX_VALUE;
            for(int num : nums){
                if(num == 0){
                    cntZero++;
                }else{ // != 0
                    min = Math.min(min,num);
                }
            }
            if(cntZero == nums.length){
                return res;
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    nums[i] -= min;
                    if(nums[i] == 0){
                        cntZero++;
                    }
                }
            }
            res++;
        }
        return res;
    }
}

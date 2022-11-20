package codeofli.leetcode.contest.c320;

public class UnequalTriplets {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if(nums[i] != nums[j]){
                    for (int k = j + 1; k < n; k++) {
                        if(nums[i] != nums[k] && nums[j] != nums[k]){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}

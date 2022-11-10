package codeofli.leetcode.contest.c318;

/**
 * @author: codeofli
 * @create: 2022-11-06 10:31
 */
public class ApplyOperations2460 {
    /**
     * lc: 优化O(1)空间复杂度
     */
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        var res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                res[idx++] = nums[i];
            }
        }
        for(int i = idx; i < n; i++){
            res[i] = 0;
        }
        return res;
    }

    public int[] applyOperations2(int[] nums) {
        int n = nums.length;
        var res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                res[idx++] = nums[i];
            }
        }
        for(int i = idx; i < n; i++){
            res[i] = 0;
        }
        return res;
    }
}

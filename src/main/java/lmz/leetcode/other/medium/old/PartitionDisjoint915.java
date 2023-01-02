package lmz.leetcode.other.medium.old;

/**
 * @author: codeofli
 * @create: 2022-10-24 19:39
 */
public class PartitionDisjoint915 {
    public int partitionDisjoint(int[] nums) {
        //2 <= nums.length <= 105
        int n = nums.length - 1;
        int left = 1, right = nums.length - 2;
        int leftMax = nums[0],rightMin = nums[n - 1];
        while(leftMax >= nums[left + 1]){
            left++;
        }
        int maxI = 0;
        for(int i = 1; i < n; i++){
            if(nums[maxI] < nums[i] ){
                maxI = i;
            }
        }
        return maxI;
    }
}

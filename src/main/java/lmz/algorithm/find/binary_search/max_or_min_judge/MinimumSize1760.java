package lmz.algorithm.find.binary_search.max_or_min_judge;

/**
 * @author: codeofli
 * @create: 2022-12-20 10:47
 */
public class MinimumSize1760 {
    /**
     *1 <= nums.length <= 10^5
     * 1 <= maxOperations, nums[i] <= 10^9
     * 二分，
     * f,f,t,t,....,靠右
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1,high = (int)1e9;
        while(low <= high){
            int mid = low +(high -low) / 2;
            if(check(nums,maxOperations,mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] nums, int maxOperations, int x) {
        for(var val : nums){
            if(val % x == 0){
                maxOperations -= val / x - 1;
            }else{
                maxOperations -= val / x;
            }
        }
        return maxOperations >= 0;
    }
}

package lmz.algorithm.contest.c351;

/**
 * @author: limingzhong
 * @create: 2023-06-25 10:29
 */
public class T3 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        final long mod = (long) (1e9 + 7);
        int left = 0,right = nums.length - 1;
        while(left < right && nums[left] != 1){
            left++;
        }

        while(left < right && nums[right] != 1){
            right--;
        }
        if(left > right){ // 没有1
            return 0;
        }
        long ans = 1;
        long cnt = 0;
        for(int i = left; i <= right; i++){
            if(i == 0){
                cnt++;
            }else{ // 1
                ans = (ans * (cnt+1)) % mod;
                cnt = 0;
            }
        }
        return (int) ans;
    }
}

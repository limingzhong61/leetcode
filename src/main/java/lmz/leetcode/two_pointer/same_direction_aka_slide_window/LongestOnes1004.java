package lmz.leetcode.two_pointer.same_direction_aka_slide_window;

/**
 * @author: limingzhong
 * @create: 2023-04-23 12:05
 */
public class LongestOnes1004 {
    class Solution {
        /**
         * 同向双指针
         */
        public int longestOnes(int[] nums, int k) {
            int n = nums.length,left = 0;

            int cnt = 0,res = 0;
            for(int right = 0; right < n; right++){
                if(nums[right] == 0) cnt++;
                while(cnt > k){
                    if(nums[left++] == 0) cnt--;
                }
                res = Math.max(res,right - left + 1);
                //System.out.printf("%d,%d,%d\n",left,right,res);
            }
            return res;
        }
    }
}

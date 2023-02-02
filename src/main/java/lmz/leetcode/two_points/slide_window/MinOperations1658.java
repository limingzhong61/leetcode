package lmz.leetcode.two_points.slide_window;

import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-01-07 10:26
 */
public class MinOperations1658 {
    /**
     * 滑动窗口找中间最长的片段使得sum(片段)=sum(nums)-x
     */
    public int minOperations(int[] nums, int x) {
        int sum = IntStream.of(nums).sum();
        int need = sum - x,maxLen = -1,n = nums.length;
        if(need < 0){ // sum < x
            return -1;
        }else if(need == 0){
            return n;
        }
        // nowSum统计[l,r)中的和
        int left = 0, right = 0,nowSum = 0;
        while (right< n) {
            if (right < nums.length) {
                nowSum += nums[right++];
            }
            while (nowSum > need && left <= right) {
                nowSum -= nums[left++];
            }
            if(nowSum == need){
                maxLen = Math.max(maxLen, right - left);
            }
            // System.out.printf("left=%d,right=%d,nowSum=%d,need=%d\n",left,right,nowSum,need);
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
    /**
     * 滑动窗口找中间最长的片段使得sum(片段)=sum(nums)-x
     */
    public int minOperations1(int[] nums, int x) {
        int sum = IntStream.of(nums).sum();
        int need = sum - x,maxLen = 0,n = nums.length;
        if(need < 0){ // sum < x
            return -1;
        }else if(need == 0){
            return n;
        }
        // nowSum统计[l,r]中的和
        int left = 0, right = 0,nowSum = nums[0];
        while (right + 1 < n) {
            while (nowSum < need && right + 1< n) {
                nowSum += nums[++right];
            }
            while (nowSum >= need && left <= right) {
                if(nowSum == need){
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                nowSum -= nums[left++];
            }
            // System.out.printf("left=%d,right=%d,nowSum=%d,need=%d\n",left,right,nowSum,need);
        }
        return maxLen == 0 ? -1 : n - maxLen;
    }
}

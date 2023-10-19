package com.lmz.leetcode.practice.two_pointer.opposite_direction;

/**
 * @author: limingzhong
 * @create: 2023-05-08 9:33
 */
public class MaxArea11 {
    class Solution {
        /**
         * 左右两端开始，距离最大；只有中间更高才能取到更大的area。
         */
        public int maxArea(int[] height) {
            int n = height.length;
            int left = 0, right = n - 1;
            int maxArea = 0;
            while (left < right) {
                maxArea =Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
                // System.out.printf("%d,%d,%d,%d\n",left,right,height[left], height[right]);
                if(height[left] < height[right]){ // 每次取最高边
                    left++;
                }else{
                    right--;
                }
            }
            return maxArea;
        }
    }
}

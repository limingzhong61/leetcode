package com.lmz.leetcode.practice.two_pointer.opposite_direction;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

/**
 * 接雨水
 * @author: limingzhong
 * @create: 2023-05-27 19:18
 */
public class Trap42 {
    /**
     * 前缀，后缀数组：
     *  把当前位置看成一个桶，那么一个位置能接的雨水是min(左边最高高度,右边最高高度）-柱子的高度
     * 双指针优化：
     * 两个指针从最左left、最右right开始，并每一次记录最左preMax、最右高度sufMax，
     * 每次取left，right高度更小的计算，如果是height[left]<height[right],因为其左最高已经确定，而height[left]<height[right]
     * 则此时left最高已经确定了就是preMax
     */
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int sum = 0;
        for (; left < right; ) {
            rightMax = Math.max(rightMax,height[right]);
            leftMax = Math.max(leftMax,height[left]);
            if (height[left] >= height[right]) {
                sum += rightMax - height[right];
                right--;
            } else {
                sum += leftMax - height[left];
                left++;
            }
        }
        return sum;
    }

    /**
     * 前缀，后缀数组：
     * 把当前位置看成一个桶，那么一个位置能接的雨水是min(左边最高高度,右边最高高度）-柱子的高度
     */
    public int trap1(int[] height) {
        int n = height.length;
        int[] preHeight = new int[n],sufHeight = new int[n];
        preHeight[0] = height[0];
        for(int i = 1; i < n; i++){
            preHeight[i] = Math.max(preHeight[i-1],height[i]);
        }
        sufHeight[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            sufHeight[i] = Math.max(sufHeight[i+1],height[i]);
        }
        int ans = 0;
        for(int i = 1; i < n; i++){
            ans += Math.min(preHeight[i],sufHeight[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap42 trap = new Trap42();
        System.out.println(trap.trap(TransformUtil.toIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]")));
        System.out.println(trap.trap(TransformUtil.toIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]")) == 6);
        System.out.println(trap.trap(TransformUtil.toIntArray("[4,2,0,3,2,5]")));
        System.out.println(trap.trap(TransformUtil.toIntArray("[4,2,0,3,2,5]")) == 9);
    }
}

package lmz.algorithm.other.old.hard;

import lmz.my.leetcode.TransformUtil;

/**
 * @author: limingzhong
 * @create: 2023-05-27 19:18
 */
public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = height[left], rightMax = height[right];
        int sum = 0;
        for (; left < right; ) {
            int minHeight = Math.min(leftMax,rightMax);

            if (height[left] >= height[right]) {
                sum += Math.max(0, minHeight - height[right]);

                right--;
            } else {
                sum += Math.max(0, minHeight - height[left]);

                left++;
            }
            rightMax = Math.max(rightMax,height[right]);
            leftMax = Math.max(leftMax,height[left]);
        }

        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        System.out.println(trap.trap(TransformUtil.toIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]")));
        System.out.println(trap.trap(TransformUtil.toIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]")) == 6);
        System.out.println(trap.trap(TransformUtil.toIntArray("[4,2,0,3,2,5]")));
        System.out.println(trap.trap(TransformUtil.toIntArray("[4,2,0,3,2,5]")) == 9);
    }
}

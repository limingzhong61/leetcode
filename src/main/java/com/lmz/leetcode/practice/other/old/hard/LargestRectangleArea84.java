package com.lmz.leetcode.practice.other.old.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea84 {
    /**
     * 单调序列：单调递增序列
     * 明确一点，遍历每个高度，是要以当前高度为基准，寻找最大的宽度 组成最大的矩形面积
     * 那就是要找左边第一个小于当前高度的下标left，再找右边第一个小于当前高度的下标right 那宽度就是这两个下标之间的距离了
     * 但是要排除这两个下标 所以是right-left-1
     * 用单调序列就可以很方便确定这两个边界了
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length,ans = 0;

        // 在前后两个位置添加一个0，减少判断；0 <= heights[i] <= 10^4
        int[] h = new int[n + 2];
        System.arraycopy(heights, 0, h, 1, n);
        //idx   单调递增
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n + 2; i++){
            while(!dq.isEmpty() && h[dq.peekLast()] > h[i]){
                int height = h[dq.pollLast()];
                // i 为右边比height小的idx,单调序列中前一个为比height更小左边的idx
                int left = dq.peekLast();    // 因为 初始的0一直存在
                int width = i - left - 1;   // 排除两个矮边分界线
                ans = Math.max(ans,width * height);
            }
            dq.addLast(i);
        }
        return ans;
    }
}

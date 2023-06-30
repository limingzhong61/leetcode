package lmz.algorithm.other.old.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleArea84 {
    /**
     * 单调栈：
     * 明确一点，遍历每个高度，是要以当前高度为基准，寻找最大的宽度 组成最大的矩形面积
     * 那就是要找左边第一个小于当前高度的下标left，再找右边第一个小于当前高度的下标right 那宽度就是这两个下标之间的距离了
     * 但是要排除这两个下标 所以是right-left-1
     * 用单调栈就可以很方便确定这两个边界了
     */
    public int largestRectangleArea(int[] heights) {
        //idx   单调递增
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length, ans = 0;
        // 在前后两个位置添加一个0，减少判断；0 <= heights[i] <= 10^4
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        for (int i = 0; i < n+2; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int h = newHeights[stack.poll()];
                int left = stack.peek(); // 因为 初始的0一直存在
                int len = i - left - 1; // 排除两个矮边分界线
                ans = Math.max(ans, len * h);
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 单调栈：
     * 明确一点，遍历每个高度，是要以当前高度为基准，寻找最大的宽度 组成最大的矩形面积
     * 那就是要找左边第一个小于当前高度的下标left，再找右边第一个小于当前高度的下标right 那宽度就是这两个下标之间的距离了
     * 但是要排除这两个下标 所以是right-left-1
     * 用单调栈就可以很方便确定这两个边界了
     */
    public int largestRectangleArea22(int[] heights) {
        //idx   单调递增
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length,ans = 0;
        int[] height = new int[n + 2];

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int h = heights[stack.poll()];
                int left = -1; // stack为空，left = -1
                if(!stack.isEmpty()){
                    left = stack.peek();
                }
                int len = i - left - 1; // 排除两个矮边分界线
                ans = Math.max(ans,len * h);
            }
            stack.push(i);
        }
        // 遍历完，right = n
        while(!stack.isEmpty()){
            int h = heights[stack.poll()];
            int left = -1; // stack为空，left = -1
            if(!stack.isEmpty()){
                left = stack.peek();
            }
            int len = n - left - 1; // 排除两个矮边分界线
            ans = Math.max(ans,len * h);
        }

        return ans;
    }


    /**
     * 单调栈
     */
    public int largestRectangleArea11(int[] heights) {
        int n = heights.length, res = 0;
        //<val,idx> 递增栈
        Deque<int[]> stack = new ArrayDeque<>();
        // 在前后两个位置添加一个0，减少判断
        int[] newHeights = new int[n + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, n);
        newHeights[n + 1] = 0;
        stack.add(new int[]{newHeights[0], 0});
        for (int i = 0; i <= n + 1; i++) {
            while (!stack.isEmpty() && stack.peek()[0] > newHeights[i]) {
                int[] pop = stack.pop();
                int wide = 0;
                wide = i - stack.peek()[1] - 1;
                int size = wide * pop[0];
                res = Math.max(res, size);
            }
            stack.push(new int[]{newHeights[i], i});
        }
        return res;
    }

    /**
     * 单调栈
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length, res = 0;
        //<val,idx> 递增栈
        Deque<int[]> stack = new ArrayDeque<>();
        // 在前后两个位置添加一个0，减少判断
        int[] newHeights = new int[n + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, n);
        newHeights[n + 1] = 0;

        for (int i = 0; i <= n + 1; i++) {
            if (stack.isEmpty()) {
                stack.add(new int[]{newHeights[i], i});
                continue;
            }
            while (!stack.isEmpty() && stack.peek()[0] > newHeights[i]) {
                int[] pop = stack.pop();
                int wide = 0;
                if (stack.isEmpty()) {
                    wide = i;
                } else {
                    wide = i - stack.peek()[1] - 1;
                }
                int size = wide * pop[0];
                res = Math.max(res, size);
            }
            stack.push(new int[]{newHeights[i], i});
        }
        return res;
    }
}

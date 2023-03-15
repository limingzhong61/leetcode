package lmz.leetcode.other.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleAreaII039 {
    /**
     * 单调栈
     */
    public int largestRectangleArea(int[] heights) {
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

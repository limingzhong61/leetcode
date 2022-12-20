package lmz.leetcode.monotonic_stack_or_queue;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures739 {
    /**
     * 因为需要找到后面的更大值得index，则可以从后往前维护一个单调上升的栈<index>
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        //1 <= temperatures.length <= 105
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 移除比当前值小或等于的元素
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.poll();
            }
            if (stack.isEmpty()) { // 没有比当前元素更大的值；
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}

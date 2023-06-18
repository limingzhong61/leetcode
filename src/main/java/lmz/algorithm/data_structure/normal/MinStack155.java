package lmz.algorithm.data_structure.normal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: limingzhong
 * @create: 2023-06-17 20:10
 */
public class MinStack155 {
    class MinStack {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();
        public MinStack() {
            minStack.push(Integer.MAX_VALUE);
        }
        //pop、top 和 getMin 操作总是在 非空栈 上调用
        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val,minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

package com.lmz.algorithm.data_structure.normal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode:
 * 使用辅助栈记录每次入栈时刻的最小值，这样就能在O(1)
 * 时间找到最小值。
 *
 */
class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    public MinStack() {
        stack.push(-1);
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }

    /**
     * 使用头插法
     * 删除堆栈顶部的元素。
     */
    public void pop() {
        if (stack.size() == 1) {
            return;
        }
        stack.pop();
        minStack.pop();
    }

    //获取堆栈顶部的元素。
    public int top() {
        if (stack.size() == 1) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if(minStack.size() == 1){
            return  -1;
        }
        return minStack.peek();
    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

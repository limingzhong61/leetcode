package com.lmz.algorithm.data_structure.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateStackSequences946 {
    /**
     * 模拟
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        for(int item : pushed){
            // 当栈顶元素为序列中下一个元素时，出栈
            while(!stack.isEmpty() && popped[index] == stack.peek()){
                stack.poll();
                index++;
            }
            stack.push(item);
        }
        return stack.isEmpty();
    }
}

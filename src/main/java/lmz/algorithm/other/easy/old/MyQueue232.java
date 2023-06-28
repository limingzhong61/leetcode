package lmz.algorithm.other.easy.old;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue232 {
    /**
     * 两个栈模拟即可
     * inStack负责入队，outStack负责出队
     */
    class MyQueue {
        Deque<Integer> inStack = new LinkedList<>();
        Deque<Integer> outStack = new LinkedList<>();

        public MyQueue() {}

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            // 如果outStack栈为空，则将inStack栈全部弹出并压入outStack栈中，然后outStack.pop()
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        public int peek() {
            // 如果outStack栈为空，则将inStack栈全部弹出并压入outStack栈中，然后outStack.pop()
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return outStack.isEmpty() && inStack.isEmpty();
        }
    }
}

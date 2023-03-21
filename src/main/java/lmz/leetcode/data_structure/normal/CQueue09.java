package lmz.leetcode.data_structure.normal;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue09 {
    /**
     * leetcode
     * 每次deleteHead 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，
     * 这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。

     */
    class CQueue {
        //用两个栈实现队列
        Deque<Integer> inStack = new LinkedList<>();
        Deque<Integer> outStack = new LinkedList<>();

        public CQueue() {

        }
        //正常添加入stack1
        public void appendTail(int value) {
            inStack.push(value);
        }
        //输出时，利用stack2
        public int deleteHead() {
            //若队列中没有元素，deleteHead 操作返回 -1
            if(outStack.isEmpty()){
                if(inStack.isEmpty()){
                    return -1;
                }
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }
    }

    class CQueue1 {
        //用两个栈实现队列
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        public CQueue1() {

        }
        //正常添加入stack1
        public void appendTail(int value) {
            stack1.push(value);
        }
        //输出时，利用stack2
        public int deleteHead() {
            //若队列中没有元素，deleteHead 操作返回 -1
            if(stack1.isEmpty()){
                return -1;
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            int result = stack2.pop();
            //还原到stack1
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return result;
        }
    }
}

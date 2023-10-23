package com.lmz.leetcode.practice.p.old.primary.design_problem;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack155 {
    /**
     * leetcode:
     * 使用辅助栈记录每次栈状态时的最小值，这样就能在O(1)
     * 时间找到最小值。
     */
    static class MinStack {
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> minStack = new LinkedList<>();
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

        public int getMin() {
            if(minStack.size() == 1){
                return  -1;
            }
            return minStack.peek();
        }
    }

    /**
     * my: 栈，先进先出，使用头插法，头结点为top指针
     * 能在O(1)时间内添加、删除栈顶元素。
     */
    static class MinStack1 {
        class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        ListNode top; //头结点，不含数据，方便操作

        public MinStack1() {
            top = new ListNode(0, null); // 头结点，无值，便于操作
        }

        //使用头插法
        public void push(int val) {
            ListNode listNode = new ListNode(val);
            listNode.next = top.next;
            top.next = listNode;
        }

        /**
         * 使用头插法
         * 删除堆栈顶部的元素。
         */
        public void pop() {
            if (top.next == null) {
                return;
            }
            top.next = top.next.next;
        }

        //获取堆栈顶部的元素。
        public int top() {
            return top.next == null ? null : top.next.val;
        }

        public int getMin() {
            if (top.next == null) {
                return -1;
            }
            int minValue = top.next.val;
            ListNode cur = top.next.next;
            while (cur != null) {
                if (cur.val < minValue) {
                    minValue = cur.val;
                }
                cur = cur.next;
            }
            return minValue;
        }


    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack155.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

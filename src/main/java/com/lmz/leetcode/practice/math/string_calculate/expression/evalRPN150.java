package com.lmz.leetcode.practice.math.string_calculate.expression;

import java.util.Deque;
import java.util.LinkedList;

public class evalRPN150 {
    /**
     * 用一个数字栈记录数字，遇到操作数计算
     *
     * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new LinkedList<>();
        for(String token : tokens){
            if("+".equals(token)){
                int b = numStack.pollLast();
                int a = numStack.pollLast();
                numStack.addLast(a+b);
            }else if("-".equals(token)){
                int b = numStack.pollLast();
                int a = numStack.pollLast();
                numStack.addLast(a-b);
            }else if("*".equals(token)){
                int b = numStack.pollLast();
                int a = numStack.pollLast();
                numStack.addLast(a*b);
            }else if("/".equals(token)){
                int b = numStack.pollLast();
                int a = numStack.pollLast();
                numStack.addLast(a/b);
            }else{ //数字
                int num = Integer.parseInt(token);
                numStack.addLast(num);
            }
        }
        return numStack.peek();
    }
}

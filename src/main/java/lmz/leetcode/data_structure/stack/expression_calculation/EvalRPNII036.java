package lmz.leetcode.data_structure.stack.expression_calculation;

import java.util.ArrayDeque;
import java.util.Arrays;

public class EvalRPNII036 {
    /**
     * tokens[i] 要么是一个算符（"+"、"-"、"*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数
     */
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<Character> charStack = new ArrayDeque<>();

        for(String s : tokens){
            if(s.charAt(0) == '+'){
                if(numStack.size() >= 2){
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    numStack.push(num1  + num2);
                }
            }else if(s.charAt(0) == '-' && s.length() == 1){
                if(numStack.size() >= 2){
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    numStack.push(num1  - num2);
                }
            }else if(s.charAt(0) == '*'){
                if(numStack.size() >= 2){
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    numStack.push(num1  * num2);
                }
            }else if(s.charAt(0) == '/'){
                if(numStack.size() >= 2){
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    numStack.push(num1  / num2);
                }
            }else{
                numStack.push(Integer.parseInt(s));
            }
            // System.out.printf("%d\n",numStack.peek());
        }

        return numStack.peek();
    }
}

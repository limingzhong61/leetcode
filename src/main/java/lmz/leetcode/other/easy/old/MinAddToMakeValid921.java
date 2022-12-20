package lmz.leetcode.other.easy.old;

import java.util.Deque;
import java.util.LinkedList;

public class MinAddToMakeValid921 {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                }else if(stack.peek() == ')' && c == '('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}

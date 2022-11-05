package codeofli.leetcode.divide_and_conquer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author: codeofli
 * @create: 2022-11-05 9:26
 */
public class ParseBoolExpr1106 {
    /**
     * 栈：
     * 通过括号划分，每个括号计算后都是一个操作数
     * 通过栈进行括号匹配。
     */
    public boolean parseBoolExpr(String expression) {
        Deque<Character> bracketStack = new ArrayDeque<>();
        Deque<Character> operatorStack = new ArrayDeque<>();
        Deque<ArrayList<Character>> boolStack = new ArrayDeque<>();
        boolStack.add(new ArrayList<>());
        for(var c : expression.toCharArray()){
            if(c == 't' || c == 'f'){
                boolStack.peek().add(c);
            }else if(c == '!' || c == '|' || c == '&'){
                operatorStack.push(c);
            }else if(c == '('){
                bracketStack.push(c);
                boolStack.push(new ArrayList<>());
            }else if(c == ')'){
                bracketStack.pop();
                // operate
                char opt = operatorStack.pop();
                boolean res;
                ArrayList<Character> boolList = boolStack.pop();
                if(opt == '!'){
                    res = ! getBool(boolList.get(0));
                }else if(opt == '|'){
                    res = false;
                    for(var b : boolList){
                        res |= getBool(b);
                    }
                }else{
                    res = true;
                    for(var b : boolList){
                        res &= getBool(b);
                    }
                }
                boolStack.peek().add(toBool(res));
            }
        }
        return getBool(boolStack.peek().get(0));
    }

    private Character toBool(boolean b) {
        return b ? 't' : 'f';
    }

    private boolean getBool(char c) {
        return c != 'f';
    }

    public static void main(String[] args) {
        ParseBoolExpr1106 parseBoolExpr1106 = new ParseBoolExpr1106();
        //System.out.println(parseBoolExpr1106.parseBoolExpr("&(|(f))"));
        System.out.println(parseBoolExpr1106.parseBoolExpr("!(&(!(t),!(!(&(f))),&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))))"));
    }
}

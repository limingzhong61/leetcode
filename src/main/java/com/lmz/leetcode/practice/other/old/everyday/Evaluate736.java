package com.lmz.leetcode.practice.other.old.everyday;

import java.util.HashMap;
import java.util.Map;

public class Evaluate736 {
    /**
     * 分治法 每遇到一个括号就进入下一次计算
     */
    public int evaluate(String expression) {
        HashMap<String, Integer> varMap = new HashMap<>();
        return evaluate(expression, varMap);
    }

    /**
     * 用一个hashMap记录分治时的变量值
     * 题目条件
     * expressoin 中的不同部分（token）之间用单个空格进行分隔
     */
    public int evaluate(String expression, Map<String, Integer> varMap) {
        int len = expression.length();
        Map<String, Integer> newVarMap = new HashMap<>(varMap);
        if (expression.startsWith("(")) {
            return evaluate(expression.substring(1, expression.length() - 1), newVarMap);
        }
        if (expression.startsWith("let")) {
            //去重前导的空格
            expression = expression.trim();
            //跳过let和空格
            int i = 4;
            int lastValue = -2;
            while (i < expression.length()) {
                if (expression.charAt(i) == '(') { // 只有表达式，直接返回
                    int tempI = i;
                    i = matchRightBracket(expression, i);
                    lastValue = evaluate(expression.substring(tempI + 1, i), newVarMap);
                    i += 2; //skip "(" + " ";
                } else if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '-') { //只有数值
                    int[] tempI = new int[]{i};
                    lastValue = getNumber(expression, tempI);
                    i = tempI[0];
                    if (i >= len) {
                        return lastValue;
                    }
                } else {
                    //获取变量名
                    StringBuilder sb = new StringBuilder();
                    for (; i < expression.length(); i++) {
                        if (expression.charAt(i) == ' ') {
                            break;
                        }
                        sb.append(expression.charAt(i));
                    }
                    String varName = sb.toString();
                    i++; //跳过一个空格
                    if (i >= len) { // 只有一个变量名结尾
                        return lastValue;
                    }
                    //获取数值
                    int num = 0;
                    if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '-') { //变量名 + 数值
                        int[] tempI = new int[]{i};
                        lastValue = getNumber(expression, tempI);
                        newVarMap.put(varName, lastValue);
                        i = tempI[0];
                    } else if (expression.charAt(i) == '(') { //变量名 + 表达式
                        // let中可能存在 "(let  x (add x y) (add x y))"的形式
                        int tempI = i;
                        i = matchRightBracket(expression, i);
                        lastValue = evaluate(expression.substring(tempI + 1, i), newVarMap);
                        i += 2; //skip "(" + " ";
                        newVarMap.put(varName, lastValue);
                    }
                    if (i >= len) {
                        return lastValue;
                    }
                }
            }
            // let 返回最后一个表达式的值
            return lastValue;
        } else if (expression.startsWith("mult")) {
            // skip string "mult"+" "
            int i = 5;
            int[] tempIndex = new int[]{i};
            int val1 = getVal(expression, newVarMap, tempIndex);
            int val2 = getVal(expression, newVarMap, tempIndex);
            return val1 * val2;
        } else if (expression.startsWith("add")) { //注意存在 的形式(add a1 1)
            // skip "add"+" "
            int i = 4;
            String[] split = expression.split(" ");
            int[] tempIndex = new int[]{i};
            int val1 = getVal(expression, newVarMap, tempIndex);
            int val2 = getVal(expression, newVarMap, tempIndex);
            return val1 + val2;
        }
        return -1;
    }

    private int matchRightBracket(String expression, int i) {
        int leftBracket = 0;
        for (; i < expression.length(); i++) {
            if (expression.charAt(i) == ')') {
                leftBracket--;
                if (leftBracket == 0) {
                    return i;
                }

            } else if (expression.charAt(i) == '(') {
                leftBracket++;
            }
        }
        return -1; //没找到
    }


    //因为java中基本数据类型不能通过方法修改，故用int[1]数组来修改
    private int getVal(String expression, Map<String, Integer> varMap, int[] i) {
        int val;
        if (expression.charAt(i[0]) == '(') {
            int tempI = i[0];
            i[0] = matchRightBracket(expression, i[0]);
            val = evaluate(expression.substring(tempI + 1, i[0]), varMap);
            i[0] += 2; //skip ")"+" "
        } else {
            //有可能是纯数字
            if (Character.isDigit(expression.charAt(i[0])) || expression.charAt(i[0]) == '-') {
                int num = getNumber(expression, i);
                return num;
            }
            //获取变量名
            StringBuilder sb = new StringBuilder();
            for (; i[0] < expression.length(); i[0]++) {
                if (expression.charAt(i[0]) == ' ') {
                    break;
                }
                sb.append(expression.charAt(i[0]));
            }
            String varName = sb.toString();
            val = varMap.get(varName);
            i[0]++; // skip space
        }
        return val;
    }

    private int getNumber(String expression, int[] i) {
        int sign = 1;
        if (expression.charAt(i[0]) == '-') {
            sign = -1;
            i[0]++;
        }
        //获取数值
        int num = 0;
        while (i[0] < expression.length() && Character.isDigit(expression.charAt(i[0]))) {
            num = num * 10 + expression.charAt(i[0]) - '0';
            i[0]++;
        }
        i[0]++; //去掉 sapce
        return num * sign;
    }

    public static void main(String[] args) {
        Evaluate736 evaluate736 = new Evaluate736();
        testCase(evaluate736, "(let x 2 (mult x (let x 3 y 4 (add x y))))", 14);
        testCase(evaluate736, "(let x 3 x 2 x)", 2);
        testCase(evaluate736, "(let x 1 y 2 x (add x y) (add x y))", 5);
        testCase(evaluate736, "(let x 2 (add (let x 3 (let x 4 x)) x))", 6);
        testCase(evaluate736, "(let a1 3 b2 (add a1 1) b2)", 4);
        testCase(evaluate736, "(let x 7 -12)", -12);
    }

    private static void testCase(Evaluate736 evaluate736, String s, int i) {
        System.out.println(evaluate736.evaluate(s));
        System.out.println(evaluate736.evaluate(s) == i);
    }
}

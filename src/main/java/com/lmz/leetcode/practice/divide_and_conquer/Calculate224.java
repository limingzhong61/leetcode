package com.lmz.leetcode.practice.divide_and_conquer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculate224 {
    class Solution {
        /**
         * 分治：每个（）都是一种运算，都会产生一个数。
         */
        int index = 0;

        public int calculate(String s) {
            int sum = 0;
            boolean add = true; //只有加减
            while (index < s.length()) {
                int num = 0;
                if (s.charAt(index) == '(') {
                    index++;
                    num = calculate(s);
                } else if (s.charAt(index) == ')') {
                    index++;
                    return sum;
                } else if (s.charAt(index) == '-') {
                    add = false;
                    index++;
                } else if (s.charAt(index) == '+') {
                    add = true;
                    index++;
                } else if (s.charAt(index) == ' ') {
                    index++;
                    continue;
                } else { //number
                    num = getNumber(s);
                }
                if (add) {
                    sum += num;
                } else {
                    sum -= num;
                }
            }
            return sum;
        }


        int getNumber(String s) {
            int num1 = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num1 = num1 * 10 + s.charAt(index) - '0';
                index++;
            }
            return num1;
        }
    }

    /**
     * 利用操作符号栈和数字栈模拟
     * <p>
     * nums ： 存放所有的数字
     * ops ：存放所有的数字以外的操作 +、-、( ，+/- 也看做是一种操作
     *
     * +/- : 需要将操作放入 ops 中。在放入之前先把栈内可以算的都算掉，使用现有的 nums 和 ops 进行计算，直到没有操作或者遇到左括号，计算结果放到 nums
     *
     */
    public int calculate(String s) {
        Deque<Character> opts = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        boolean hasNumber = false;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '(') {
                hasNumber = false;
                opts.addLast(c);
            } else if (c == ')') { // 计算到最近一个左括号为止,之前前一个‘(' 到当前的')'之间的内容
                // 计算到最近一个左括号为止
                while (!opts.isEmpty()) {
                    char op = opts.peekLast();
                    if (op != '(') {
                        calc(nums, opts);
                    } else {
                        opts.pollLast();
                        break;
                    }
                }

            } else if (Character.isDigit(c)) {
                hasNumber = true;
                int num = c - '0';
                // 获取数字
                while (i + 1 < cs.length && Character.isDigit(cs[i + 1])) {
                    num = num * 10 + cs[i + 1] - '0';
                    i++;
                }
                nums.addLast(num);
            } else if (cs[i] == ' ') {
                continue;
            } else { // + -
                // 特殊情况 ’-‘ 为开始节点 ,如 -1，1+(-2+1); 补充一个0便于计算
                if (cs[i] == '-' && !hasNumber) {
                    nums.addLast(0);
                }
                //在放入之前先把栈内可以算的都算掉，使用现有的 nums 和 ops 进行计算，直到没有操作或者遇到左括号，计算结果放到 nums
                while (!opts.isEmpty() && opts.peekLast() != '(') calc(nums, opts);
                opts.addLast(cs[i]);

            }
        }
        while (!opts.isEmpty()) calc(nums, opts);
        return nums.pollLast();
    }

    private static void calc(Deque<Integer> nums, Deque<Character> opts) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (opts.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char opt = opts.pollLast();
        int x;
        if (opt == '+') {
            x = a + b;
        } else {
            x = a - b;
        }
        nums.addLast(x);
    }

    public static void main(String[] args) {
        Calculate224 calculate224 = new Calculate224();
        testCase(calculate224, "1-(5)", -4);
        testCase(calculate224, " 2-1 + 2 ", 3);
        testCase(calculate224, "-(2 + 3)", -5);
        testCase(calculate224, "-1", -1);
        testCase(calculate224, "1 + 1", 2);
        testCase(calculate224, "(1+(4+5+2)-3)+(6+8)", 23);
    }


    private static void testCase(Calculate224 calculate224, String s, int x) {
        //calculate224.index = 0;
        System.out.println(calculate224.calculate(s));
        //calculate224.index = 0;
        System.out.println(calculate224.calculate(s) == x);
    }
}










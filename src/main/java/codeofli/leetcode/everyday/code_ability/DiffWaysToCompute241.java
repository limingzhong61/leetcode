package codeofli.leetcode.everyday.code_ability;

import codeofli.my.leetcode.TransformUtil;
import codeofli.my.util.equals.EqualsUtil;

import java.util.*;

public class DiffWaysToCompute241 {
    /**
     * leetcode:分治，选择了第i个操作符operator（选择了相当于最后计算），然后计算左右（0,i）(i,length)的值
     * 每个子问题都是求表达式的值，单个数字也是值
     * 注意，每个表达式因为操作符顺序的关系都有多个可能的不同值。
     */
    public List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        return dfs(chars, 0, chars.length - 1);
    }

    private List<Integer> dfs(char[] expression, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (!Character.isDigit(expression[i])) {
                List<Integer> leftList = dfs(expression, left, i - 1);
                List<Integer> rightList = dfs(expression, i + 1, right);
                for (var leftVal : leftList) {
                    for (var rightVal : rightList) {
                        list.add(compute(expression[i], leftVal, rightVal));
                    }
                }
            }
        }
        if (list.isEmpty()) {//纯数字，expression[left,right]中没符号
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum = sum * 10 + expression[i] - '0';
            }
            list.add(sum);
            return list;
        }
        return list;
    }

    private int compute(Character operator, int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            //case '/':
            //    return a/b;
        }
        return -1;
    }

    public static void main(String[] args) {
        DiffWaysToCompute241 diffWaysToCompute241 = new DiffWaysToCompute241();

        testCase(diffWaysToCompute241, "2-1-1", "[0,2]");

        testCase(diffWaysToCompute241, "2*3-4*5", "[-34,-14,-10,-10,10]");
        testCase(diffWaysToCompute241, "11", "[11]");
    }

    private static void testCase(DiffWaysToCompute241 diffWaysToCompute241, String s, String s2) {
        System.out.println(diffWaysToCompute241.diffWaysToCompute(s));
        System.out.println(EqualsUtil.EqualIgnoreOrder(diffWaysToCompute241.diffWaysToCompute(s),
                TransformUtil.toArrayList(s2)));
    }
}

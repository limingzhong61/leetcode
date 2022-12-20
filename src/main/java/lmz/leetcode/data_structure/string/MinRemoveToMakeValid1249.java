package lmz.leetcode.data_structure.string;

import java.util.Deque;
import java.util.LinkedList;

public class MinRemoveToMakeValid1249 {
    /**
     * 括号匹配，使用stack
     * 用一个数组标记字母是否删除，遍历一遍后通过标记数组添加形成字符串
     */
    public String minRemoveToMakeValid(String s) {

        //记录没有匹配成功的括号‘(’
        Deque<Integer> indexStack = new LinkedList<>();
        char[] cs = s.toCharArray();
        boolean[] delChar = new boolean[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (')' == s.charAt(i)) {
                if (!indexStack.isEmpty() && cs[indexStack.peek()] == '(') { //括号匹配
                    Integer index = indexStack.poll(); // '(' 找到匹配的括号，标记不删除
                    delChar[index] = false;
                } else { // ')' 没有匹配的括号，标记删除
                    delChar[i] = true;
                }
            } else if ('(' == s.charAt(i)) {
                indexStack.add(i);  // 默认'(' 没有匹配的括号，标记删除
                delChar[i] = true;
            } //else 字母
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (!delChar[i]) {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinRemoveToMakeValid1249 minRemoveToMakeValid1249 = new MinRemoveToMakeValid1249();
        testCase(minRemoveToMakeValid1249, "lee(t(c)o)de)", "lee(t(c)o)de");
        testCase(minRemoveToMakeValid1249, "a)b(c)d", "ab(c)d");
        testCase(minRemoveToMakeValid1249, "))((", "");
    }

    private static void testCase(MinRemoveToMakeValid1249 minRemoveToMakeValid1249, String s, String anObject) {
        System.out.println(minRemoveToMakeValid1249.minRemoveToMakeValid(s));
        System.out.println(minRemoveToMakeValid1249.minRemoveToMakeValid(s).equals(anObject));
    }
}

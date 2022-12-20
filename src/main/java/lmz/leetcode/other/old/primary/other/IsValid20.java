package lmz.leetcode.other.old.primary.other;

import java.util.*;

//20. 有效的括号
public class IsValid20 {
    /**
     * my:利用栈
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
                    return false;
                };
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid20 isValid20 = new IsValid20();
        System.out.println(isValid20.isValid("()"));
        System.out.println(isValid20.isValid("()[]{}"));
        System.out.println(isValid20.isValid("(]"));
        System.out.println(isValid20.isValid("([)]"));
        System.out.println(isValid20.isValid("{[]}"));
        System.out.println(isValid20.isValid("]"));
    }
}

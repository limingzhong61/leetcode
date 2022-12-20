package lmz.leetcode.data_structure.string;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DecodeString394 {
    /**
     * 栈操作
     * 一个数字栈，一个字符串栈
     */
    int index;

    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        for (index = 0; index < s.length(); index++) {
            if (Character.isDigit(s.charAt(index))) {
                int repeatTime = getNumber(s);
                stack.push(String.valueOf(repeatTime));
            } else if (s.charAt(index) == ']') { //开始出栈
                ArrayList<String> list = new ArrayList<>();
                //开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字
                //，就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈

                while (!stack.peek().equals("[")) {
                    list.add(stack.poll());
                }
                Collections.reverse(list);
                stack.poll(); // remove '['
                //反转序列值
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(str);
                }
                stack.push(sb.toString().repeat(Integer.parseInt(stack.poll())));
            } else { // '[' 和字母直接入栈
                stack.push(String.valueOf(s.charAt(index)));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    private int getNumber(String s) {
        int num = s.charAt(index) - '0';
        while (index + 1 < s.length() && Character.isDigit(s.charAt(index + 1))) {
            num = num * 10 + s.charAt(index + 1) - '0';
            index++;
        }
        return num;
    }

    /**
     * 递归
     */


    public String decodeString1(String s) {
        StringBuilder res = new StringBuilder();
        for (; index < s.length(); index++) {
            if (Character.isDigit(s.charAt(index))) {
                int repeatTime = getNumber(s);
                index += 2;
                String repeat = decodeString(s);
                res.append(repeat.repeat(repeatTime));
            } else if (Character.isLowerCase(s.charAt(index))) {
                res.append(s.charAt(index));
            } else if (s.charAt(index) == ']') {
                //index++;
                return res.toString();
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        DecodeString394 decodeString394 = new DecodeString394();
        //System.out.println(decodeString394.decodeString("3[a]2[bc]"));
        //System.out.println(decodeString394.decodeString("3[a]2[bc]").equals("aaabcbc"));
        //System.out.println(decodeString394.decodeString("3[a2[c]]"));
        //System.out.println(decodeString394.decodeString("23[abc]33[cd]ef"));
        //System.out.println(decodeString394.decodeString("100[leetcode]"));
        System.out.println(decodeString394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}

package lmz.algorithm.data_structure.stack;

import java.util.*;

public class DecodeString394 {
    /**
     * 优化版本： 在 [ [ 之间之后存在一个数字digit和字符串res，则每次以此为分割即可
     * 在 [ ] 之间只会有一个字符串
     * 在遇到] 时， res =  strStack.poll() +  res * time;
     * 栈操作: 括号匹配加强版
     * 一个数字栈，一个字符串栈
     * 字符串栈：每遇到一个右括号就解决的左括号之前的匹配
     */
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        int digit = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n;i++ ) {
            //碰到括号，重置 记录digit和当前sb，归零。
            if (cs[i] == '[') { // 是数字
                numStack.push(digit);
                strStack.push(res.toString());
                digit = 0;
                res = new StringBuilder();
            } else if (cs[i] == ']') {
                //出最近的一个左括号入的digit ,当前res进行计算不入栈
                int time = numStack.pop();
                 res.append(res.toString().repeat(time-1));
                //与括号外合并
                 res.insert(0,strStack.poll());
            } else if (Character.isLetter(cs[i])) {
                res.append(cs[i]);
            }else if(Character.isDigit(cs[i])){
                digit = digit * 10 + cs[i] - '0';
            }

        }
        return res.toString();
    }

    /**
     * 栈操作: 括号匹配加强版
     * 一个数字栈，一个字符串栈
     * 字符串栈：每遇到一个右括号就解决的左括号之前的匹配
     */
    public String decodeString1(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; ) {
            if (Character.isDigit(cs[i])) { // 是数字
                int digit = 0;
                while (i < n && Character.isDigit(cs[i])) {
                    digit = digit * 10 + cs[i] - '0';
                    i++;
                }
                numStack.push(digit);
            } else if (cs[i] == '[') {
                strStack.push("[");
                i++;
            } else if (cs[i] == ']') {
                StringBuilder sb = new StringBuilder();
                int time = numStack.pop();
                while (!"[".equals(strStack.peek())) {
                    sb.insert(0, strStack.poll());
                }
                strStack.pop(); // "["
                strStack.push(sb.toString().repeat(time));
                i++;
            } else if (Character.isLetter(cs[i])) {
                StringBuilder t = new StringBuilder();
                while (i < n && Character.isLetter(cs[i])) {
                    t.append(cs[i]);
                    i++;
                }
                strStack.push(t.toString());
            }

        }
        // 最后ans剩余的就是重复次数只有一次的答案
        StringBuilder ans = new StringBuilder();
        while (!strStack.isEmpty()) {
            ans.insert(0, strStack.poll());
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        DecodeString394 decodeString394 = new DecodeString394();
        //System.out.println(decodeString394.decodeString("3[a]2[bc]"));
        //System.out.println(decodeString394.decodeString("3[a]2[bc]").equals("aaabcbc"));
        //System.out.println(decodeString394.decodeString("3[a2[c]]"));
        //System.out.println(decodeString394.decodeString("23[abc]33[cd]ef"));
        //System.out.println(decodeString394.decodeString("100[leetcode]"));
        System.out.println(decodeString394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(decodeString394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef").equals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
    }
}

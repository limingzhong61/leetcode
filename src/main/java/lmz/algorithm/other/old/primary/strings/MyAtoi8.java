package lmz.algorithm.other.old.primary.strings;

import java.util.HashMap;
import java.util.Map;

public class MyAtoi8 {
    /**
     * leetCode:
     * 确定有限状态机（deterministic finite automaton, DFA）
     */
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            if(!automaton.get(str.charAt(i))){
                return (int) (automaton.sign * automaton.ans);
            }
        }
        return (int) (automaton.sign * automaton.ans);
    }

    class Automaton {
        int sign = 1; //默认为正
        long ans; // 防止溢出;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<>() {{
            put("start", new String[]{"start", "signed", "number", "end"});
            put("signed", new String[]{"end", "end", "number", "end"});
            put("number", new String[]{"end", "end", "number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};


        public boolean get(char c) {
            state = table.get(state)[getCol(c)];
            if ("number".equals(state)) {
                ans = ans * 10 + c - '0';
                if (sign == 1 && ans > (long) Integer.MAX_VALUE) {
                    ans = Integer.MAX_VALUE;
                    return false;
                } else if (sign != 1 && ans >  -(long)Integer.MIN_VALUE) {
                    ans = Integer.MIN_VALUE;
                    return false;
                }
            } else if ("signed".equals(state)) {
                sign = c == '-' ? -1 : 1;
            }else  if("end".equals(state)){
                return false;
            }
            return true;
        }

        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    /**
     * 转换数字，用整数类型接收更方便
     * 溢出的条件
     * res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit >= Integer.MAX_VALUE % 10
     * res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && digit >= -(Integer.MIN_VALUE % 10)
     */
    public int myAtoi2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int res = 0;
        boolean isNegative = false;
        int i = 0;
        int sign = 1;
        while (i < length && chars[i] == ' ') { //前导空格
            i++;
        }
        if (i < length && chars[i] == '-') { //负号
            sign = -1;
            i++;
        } else if (i < length && chars[i] == '+') { //正号
            i++;
        }
        while (i < length && Character.isDigit(chars[i])) {
            int digit = chars[i] - '0';
            //判断加入digit后是否溢出

            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit >= Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }

            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && digit >= -(Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            // 每一步都把符号位乘进去
            res = res * 10 + digit * sign;
            i++;
        }
        return res;
    }

    //my:先得到数字字符，再判断大小
    public int myAtoi1(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        boolean isNegative = false;
        int i = 0;
        while (i < length && chars[i] == ' ') { //前导空格
            i++;
        }
        if (i < length && chars[i] == '-') { //负号
            sb.append("-");
            isNegative = true;
            i++;
        } else if (i < length && chars[i] == '+') { //正号
            i++;
        }
        boolean hasDigit = false;
        while (i < length && Character.isDigit(chars[i])) {
            if (!hasDigit && chars[i] == '0') { //跳过首位0
                i++;
                continue;
            }
            hasDigit = true;
            sb.append(chars[i]);
            i++;
        }
        if ("".equals(sb.toString())) {
            return 0;
        }
        if ("-".equals(sb.toString())) { //"-+12"，只有负号的情况
            return 0;
        }
        String maxString = String.valueOf(Integer.MAX_VALUE);
        String minString = String.valueOf(Integer.MIN_VALUE);
        //负数
        if (isNegative) {
            //越界
            if (sb.length() > minString.length() || (sb.length() == minString.length() && sb.toString().compareTo(minString) > 0))
                return Integer.MIN_VALUE;
        } else {//正数
            //越界
            if ((sb.length() > maxString.length()) || (sb.length() == maxString.length() && sb.toString().compareTo(maxString) > 0)) {
                return Integer.MAX_VALUE;
            }
        }
        //System.out.println(sb.toString());
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        MyAtoi8 atoi8 = new MyAtoi8();
        System.out.println(atoi8.myAtoi("-+12") );
        System.out.println(atoi8.myAtoi("-21474836469"));
        System.out.println(atoi8.myAtoi("42"));
        System.out.println(atoi8.myAtoi("   -42"));
        System.out.println(atoi8.myAtoi("   -4"));
        System.out.println(atoi8.myAtoi( "4193 with words"));
        System.out.println(atoi8.myAtoi( "2147483648"));
        System.out.println(atoi8.myAtoi("-2147483649"));
    }
}

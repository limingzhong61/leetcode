package mars.leetcode.primary.strings;

public class MyAtoi8 {
    /**
     * leetCode:
     * 确定有限状态机（deterministic finite automaton, DFA）
     */
    public int myAtoi(String s) {

        return 0;
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

            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && digit >= -(Integer.MIN_VALUE % 10) ){
                return Integer.MIN_VALUE;
            }
            // 每一步都把符号位乘进去
            res = res * 10 + digit *sign;
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
        //System.out.println(atoi8.myAtoi("-+12"));
        //System.out.println(atoi8.myAtoi("-21474836469"));
        //System.out.println(atoi8.myAtoi("42"));
        //System.out.println(atoi8.myAtoi("   -42"));
        //System.out.println(atoi8.myAtoi("   -4"));
        //System.out.println(atoi8.myAtoi( "4193 with words"));
        //System.out.println(atoi8.myAtoi( "2147483648"));
        System.out.println(atoi8.myAtoi( "-2147483649"));
    }
}

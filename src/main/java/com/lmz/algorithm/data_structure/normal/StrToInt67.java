package com.lmz.algorithm.data_structure.normal;

public class StrToInt67 {
    /**
     * leetcode： 用int判断是否越界
     * 2147483647
     * -2147483648
     * res > 2147483647 就越界了（2147483647正常计算就行了）
     */
    public int strToInt1(String str) {

        // 跳过空格
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        //空串|空格字符串
        if (str.length() == index) {
            return 0;
        }
        int res = 0;
        int sign = 1;
        int boundary = Integer.MAX_VALUE / 10;
        //符号位判断
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        for (int i = index; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                //数值越界判断
                if (res > boundary || res == boundary && str.charAt(i) > '7') {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + str.charAt(i) - '0';
            } else {
                return res * sign;
            }
        }
        return res * sign;
    }

    /**
     * 模拟： 用long判断是否越界
     */
    public int strToInt2(String str) {
        // 跳过空格
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        long res = 0;
        int symbol = 1;
        boolean hasSymbol = false;
        boolean hasNumber = false;
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                //两个符号位,错误格式
                if (hasSymbol || hasNumber) {
                    return (int) res * symbol;
                }
                symbol = -1;
                hasSymbol = true;
            } else if (str.charAt(i) == '+') {
                //两个符号位,错误格式
                if (hasSymbol || hasNumber) {
                    return (int) res * symbol;
                }
                hasSymbol = true;
            } else if (Character.isDigit(str.charAt(i))) {
                hasNumber = true;
                res = res * 10 + str.charAt(i) - '0';
                //数值越界判断
                if (symbol == -1) {
                    if (-res < (long) Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (res > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                return (int) res * symbol;
            }
        }
        return (int) res * symbol;
    }

    /**
     * 模拟： 用long判断是否越界
     */
    public int strToInt(String str) {
        // 跳过空格
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        long res = 0;
        int symbol = 1;
        boolean hasSymbol = false;
        boolean hasNumber = false;
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                //两个符号位,错误格式
                if (hasSymbol || hasNumber) {
                    return (int) res * symbol;
                }
                symbol = -1;
                hasSymbol = true;
            } else if (str.charAt(i) == '+') {
                //两个符号位,错误格式
                if (hasSymbol || hasNumber) {
                    return (int) res * symbol;
                }
                hasSymbol = true;
            } else if (Character.isDigit(str.charAt(i))) {
                hasNumber = true;
                res = res * 10 + str.charAt(i) - '0';
                //数值越界判断
                if (symbol == -1 || -res < (long) Integer.MIN_VALUE) { // 负值越界
                    return Integer.MIN_VALUE;
                } else if(res > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            } else {
                return (int) res * symbol;
            }
        }
        return (int) res * symbol;
    }

    public static void main(String[] args) {
        StrToInt67 strToInt67 = new StrToInt67();
        System.out.println(strToInt67.strToInt("4193 with words"));
        System.out.println(strToInt67.strToInt("4193 with words") == 4193);
        System.out.println(strToInt67.strToInt("words and 987"));
        System.out.println(strToInt67.strToInt("words and 987") == 0);
        System.out.println(strToInt67.strToInt("-91283472332"));
        System.out.println(strToInt67.strToInt("-91283472332") == -2147483648);
        System.out.println(strToInt67.strToInt("   -42"));
        System.out.println(strToInt67.strToInt("   -42") == -42);
        System.out.println(strToInt67.strToInt("+1"));
        System.out.println(strToInt67.strToInt("+1") == +1);
        System.out.println(strToInt67.strToInt("0-1"));
        System.out.println(strToInt67.strToInt("0-1") == 0);
        System.out.println(strToInt67.strToInt("-5-"));
        System.out.println(strToInt67.strToInt("-5-") == -5);
        System.out.println(strToInt67.strToInt("2147483646"));
        System.out.println(strToInt67.strToInt("2147483646") == 2147483646);
        System.out.println(strToInt67.strToInt("-2147483647"));
        System.out.println(strToInt67.strToInt("-2147483647") == -2147483647);
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
    }
}

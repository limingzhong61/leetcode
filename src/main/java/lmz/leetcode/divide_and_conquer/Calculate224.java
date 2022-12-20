package lmz.leetcode.divide_and_conquer;

public class Calculate224 {
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

    public static void main(String[] args) {
        Calculate224 calculate224 = new Calculate224();
        testCase(calculate224, "(1+(4+5+2)-3)+(6+8)", 23);
        testCase(calculate224, "1 + 1", 2);
        testCase(calculate224, " 2-1 + 2 ", 3);
    }

    private static void testCase(Calculate224 calculate224, String s, int x) {
        calculate224.index = 0;
        System.out.println(calculate224.calculate(s));
        calculate224.index = 0;
        System.out.println(calculate224.calculate(s) == x);
    }
}










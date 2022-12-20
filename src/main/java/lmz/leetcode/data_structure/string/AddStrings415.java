package lmz.leetcode.data_structure.string;

import java.math.BigInteger;

/**
 * "6913259244"
 * "71103343"
 */
public class AddStrings415 {
    /**
     * 使用BigInteger
     */
    public String addStrings(String num1, String num2) {
        return new BigInteger(num1).add(new BigInteger(num2)).toString();
    }
    /**
     * 1 <= num1.length, num2.length <= 10^4
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     */
    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || remainder != 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + remainder;
            remainder = sum / 10;
            sb.append(sum % 10);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings415 addStrings415 = new AddStrings415();
        System.out.println(addStrings415.addStrings("11", "123"));
        System.out.println(addStrings415.addStrings("11", "123").equals("134"));
        System.out.println(addStrings415.addStrings("6913259244","71103343"));
        System.out.println(addStrings415.addStrings("6913259244","71103343").equals("6984362587"));
        System.out.printf(String.valueOf(3 << 3));
    }
}

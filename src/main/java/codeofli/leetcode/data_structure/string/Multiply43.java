package codeofli.leetcode.data_structure.string;

import java.math.BigInteger;

public class Multiply43 {
    /**
     * leetcode:做乘法
     * 如果使用数组代替字符串存储结果，则可以减少对字符串的操作。
     * 最多m+n位
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        //用一个数组记录中间的乘积结果值
        int[] multArr = new int[len1 + len2];
        for(int i = len1 -  1; i >= 0; i--){
            int x = num1.charAt(i) - '0';
            for(int j = len2 -1; j >= 0; j--){
                int y = num2.charAt(j) - '0';
                multArr[i + j + 1] += x * y;
            }
        }
        //处理进位情况
        for(int i = len1+len2-1; i > 0; i--){
            multArr[i-1] += multArr[i] / 10;
            multArr[i] %= 10;
        }
        int index = multArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < len1+len2) {
            ans.append(multArr[index]);
            index++;
        }
        return ans.toString();
    }

    /**
     * 使用BigInteger
     */
    public String multiply2(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }

    /**
     * 每次取num1中的一位数相乘，然后和sb字符结果相加
     */
    public String multiply1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int start = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int remainder = 0;
            int x = num1.charAt(i) - '0';
            int idx = start;
            start++;
            for (int j = num2.length() - 1; j >= 0 || remainder != 0; j--) {
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int z = 0;
                if (sb.length() > idx) {
                    z = sb.charAt(idx) - '0';
                }
                int res = x * y + remainder + z;
                if (sb.length() > idx) {
                    sb.setCharAt(idx, (char) (res % 10 + '0'));
                } else {
                    sb.append((char) (res % 10 + '0'));
                }
                remainder = res / 10;
                idx++;
            }

        }
        //去掉前导可能存在的0
        for (int i = sb.length() - 1; i >= 1; i--) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
            } else { // 存在非0数
                break;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply43 multiply43 = new Multiply43();
        System.out.println(multiply43.multiply("123", "456"));
        System.out.println(multiply43.multiply("123", "456").equals("56088"));
        System.out.println(multiply43.multiply("9133", "0"));
        System.out.println(multiply43.multiply("9133", "0").equals("0"));

    }
}

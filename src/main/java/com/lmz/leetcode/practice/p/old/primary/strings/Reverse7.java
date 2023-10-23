package com.lmz.leetcode.practice.p.old.primary.strings;

public class Reverse7 {
    /**
     * my：翻转后判断是否溢出
     *  可以处理翻转后超出int范围的问题
     *  细节注意：Integer.MIN_VALUE = -Integer.MIN_VALUE
     */
    public int reverse2(int x) {
        //解决Integer.MIN_VALUE = -Integer.MIN_VALUE
        if(x == 0 || x == Integer.MIN_VALUE){
            return 0;
        }
        StringBuilder sb =new StringBuilder();
        int symbol = 1;
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            sb.append("-");
            x = -x;
        }
        while (x != 0) {
            int temp = x % 10;
            sb.append(temp);
            x /= 10;
        }
        String intMin = String.valueOf(Integer.MIN_VALUE);
        String intMax = String.valueOf(Integer.MAX_VALUE);
        // out range check
        String result = sb.toString();
        if(isNegative && intMin.length() == result.length() && intMin.compareTo(result) < 0){
            return 0;
        }
        if(!isNegative && intMax.length() == result.length() && intMax.compareTo(result) < 0){
            return 0;
        }
        return Integer.parseInt(result);
    }

    /**
     * leetcode
     * 边反转，边判断
     * 初始范围确保了反转后不用关心最后一位，直接用十分之一是否溢出就可以判断
     * int 范围[2147483647,-2147483648]保证了输入首位只能是1,2翻转后
     * 最多为xxxxxxxxx2比7小，故不用判断最后一位
     */
    public int reverse(int x) {
        int reverse = 0;
        while(x != 0){
            if( reverse > Integer.MAX_VALUE/10 || reverse < Integer.MIN_VALUE/10){
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            reverse = reverse *10 + digit;
        }
        return  reverse;
    }


    public static void main(String[] args) {
        Reverse7 reverse7 = new Reverse7();
        System.out.println(reverse7.reverse(-2147483648));
        //int testValue = -2147483648;
        //String binaryString = Integer.toBinaryString(testValue);
        //String binaryString2 = Integer.toBinaryString(-testValue);
        //System.out.println(binaryString);
        //System.out.println(binaryString2);
    }
}

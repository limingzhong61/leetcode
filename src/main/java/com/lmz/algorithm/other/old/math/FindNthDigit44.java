package com.lmz.algorithm.other.old.math;

public class FindNthDigit44 {
    /**
     * leetcode 优化代码
     */
    public int findNthDigit1(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            start *= 10;
            digit += 1;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }


    /**
     * 确定 n 所在数字的位数 ，记为 digit ；
     * 确定 n 所在的 数字 ，记为 num ；
     * 确定 n 是 num 中的哪一数位，并返回结果。
     */
    public int findNthDigit2(int n) {
        //确定n所在数字的位数 ，记为digit；
        // 位数为digit时，sum 表示当前 的位数，start表示位数为digit时开始的位置
        int digit = 1;
        long  start = 1,count = 9;
        while (n > count) {
            n -= count;     // 减去 digit时相应的位数
            digit++;    //1,2,3...
            start *= 10;    //1,10,100...

            count = digit * start * 9;// 当前digit位数时的个数；
            //System.out.printf("%d,%d,%d\n", digit, count, start);
        }

        // 确定n所在的数字 ，记为 num ；
        /**
         * 此时n表示从digit位开始数字的个数，如，1,10,100...
         * 1-digit 为 第一个，digit+1——digit*2 为第二个，故需要
         * (n - 1) / digit 计算出 num
         */
        long num = start + (n - 1) / digit;

        // 字符串从0开始
        String s = String.valueOf(num);
        return s.charAt((n - 1) % digit) - '0';
    }

    public int findNthDigit(int n) {
        if(n < 10) return n;
        long len = 1,cnt = 9;
        long totol = len * cnt; // 最开始10个
        /*  2, 90
            3, 900
            4, 999
        */
        while(n > totol){
            long next = totol + (len+1) * (cnt * 10);
            if(next > n) break;
            totol = next;
            len++;
            cnt *= 10;
        }
        len++;
        n -= totol; //在第len位中多了多少位
        long start = 1;
        for(int i = 1; i < len; i++){
            start *= 10;
        }

        long step = n / len;
        // 向上取整
        if(n % len != 0) step++;
        long value = step - 1 + start;
        System.out.printf("%d,%d,%d,%d\n",n,totol,start,value);
        return String.valueOf(value).charAt((int) ((n - 1) % len)) - '0';
    }

    public static void main(String[] args) {
        FindNthDigit44 findNthDigit44 = new FindNthDigit44();

        testCase(findNthDigit44, 1000000000, 1);


        testCase(findNthDigit44, 10, 1);
        testCase(findNthDigit44, 11, 0);

        testCase(findNthDigit44, 3, 3);

    }

    private static void testCase(FindNthDigit44 findNthDigit44, int n, int x) {
        System.out.println(findNthDigit44.findNthDigit(n));
        System.out.println(findNthDigit44.findNthDigit(n) == x);
    }
}

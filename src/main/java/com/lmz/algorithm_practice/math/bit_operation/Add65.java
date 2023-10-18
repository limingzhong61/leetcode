package com.lmz.algorithm_practice.math.bit_operation;

public class Add65 {
    public int add1(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    /**
     * 每次计算一位
     */
    public int add(int a, int b) {
        int factor = 0, ans = 0;
        for (int i = 0; i <= 31; i++) {
            int x = 0, y = 0;
            if ((a & 1) != 0) x = 1;
            if ((b & 1) != 0) y = 1;

            int result = x ^ y ^ factor;

            // 3个中有两个1即可
            factor = (x & y) | (x & factor) | (y & factor);

            ans |= (result << i);
            a >>>= 1;
            b >>>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        Add65 add65 = new Add65();


        testCase(add65, -2, -8, -10);
        testCase(add65, 3, 7, 10);

        testCase(add65, 3, -8, -5);

        testCase(add65, 1, 1, 2);

        testCase(add65, 5, 4, 9);

        testCase(add65, 10, 4, 14);

        testCase(add65, Integer.MIN_VALUE, Integer.MAX_VALUE, -1);
    }

    private static void testCase(Add65 add65, int a, int b, int x) {
        System.out.println(add65.add(a, b));
        System.out.println(add65.add(a, b) == x);
    }
}

package codeofli.leetcode.graph_parse_ds.divide_and_conquer;

public class MyPow16 {
    /**
     * my:迭代-快速幂
     * 每个额外乘的x对应了 7 的二进制表示 (1001101)_2中的每个 1！
     * 注意：n可以为负数
     */
    public double myPow(double x, int n) {
        double res = 1;
        // 贡献的初始值为 x
        double xContribute = x;
        long pow = n;
        if (pow < 0) {
            pow = -n;
            xContribute = 1 / x;
        }
        // 在对 N 进行二进制拆分的同时计算答案
        while (pow != 0) {
            if (pow % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                res *= xContribute;
            }
            xContribute *= xContribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            pow /= 2;
        }
        return  res;
    }

    /**
     * my:递归分治-递归快速幂
     * 注意：n可以为负数
     */
    public double quickPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = quickPow(x, n / 2);
        double single = 1;
        if (n % 2 == 1) {
            single = x;
        } else if (n % 2 == -1) {
            single = 1 / x;
        }
        return half * half * single;
    }

    /**
     * my:递归分治-递归快速幂
     * 注意：n可以为负数
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = quickPow(x, n / 2);
        double single = 1;
        if (n % 2 == 1) {
            single = x;
        } else if (n % 2 == -1) {
            single = 1 / x;
        }
        return half * half * single;
    }

    public static void main(String[] args) {
        MyPow16 myPow16 = new MyPow16();
        float diff = 1e-6F;
        System.out.println(myPow16.myPow(2.00000, 10));
        System.out.println(Math.abs(myPow16.myPow(2.00000, 10) - 1024.00000) < diff);
        System.out.println(myPow16.quickPow(2.10000, 3));
        System.out.println(Math.abs(myPow16.myPow(2.10000, 3) - 9.26100) < diff);
        System.out.println(myPow16.quickPow(2.00000, -2));
        System.out.println(Math.abs(myPow16.myPow(2.00000, -2) - 0.25000) < diff);
        System.out.println(myPow16.quickPow(2.00000, 0));
        System.out.println(Math.abs(myPow16.myPow(2.00000, 0) - 1) < diff);
        System.out.println(myPow16.quickPow(0.00001, 2147483647));
        System.out.println(Math.abs(myPow16.myPow(0.00001, 2147483647) - 0) < diff);
        //System.out.println(-Integer.MIN_VALUE  == Integer.MIN_VALUE);
    }
}

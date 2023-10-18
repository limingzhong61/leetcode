package com.lmz.algorithm_practice.math.bit_operation;

public class IsPowerOfTwo231 {
    //直接将 n 二进制表示的最低位 1 移除
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 直接获取 n二进制表示的最低位的 1
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & -n) == n;
    }
    /**
     * 判断是否为最大 2 的幂的约数
     */
    static final int BIG = 1 << 30;
    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIG % n == 0;
    }
}

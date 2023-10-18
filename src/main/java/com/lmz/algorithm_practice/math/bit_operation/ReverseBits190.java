package com.lmz.algorithm_practice.math.bit_operation;

public class ReverseBits190 {
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        n = n >>> 1 & M1 | (n & M1) << 1;   //每2位中低1位和高1位交换; 1010是a,0101是5
        n = n >>> 2 & M2 | (n & M2) << 2;   //每4位中低2位和高2位交换; 1100是c,0011是3
        n = n >>> 4 & M4 | (n & M4) << 4;   //每8位中低4位和高4位交换;
        n = n >>> 8 & M8 | (n & M8) << 8;   //每16位中低8位和高8位交换; 1111是f
        return n >>> 16 | n << 16; //低16位与高16位交换
    }

    /**
     * leetcode:
     * java使用>>>，进行无符号右移
     */
    public int reverseBits2(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //第i位为1
            ans |=(n & 1) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }

    //my: you need treat n as an unsigned value
    public int reverseBits1(int n) {
        // System.out.println(n);
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //第i位为1
            if (((1 << i) & n) != 0) {
                ans += 1 << (31 - i);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ReverseBits190 reverseBits190 = new ReverseBits190();
        System.out.println(reverseBits190.reverseBits(43261596));
    }
}

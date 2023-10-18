package com.lmz.algorithm_practice.math.bit_operation;

public class HammingDistance461 {
    /**
     * my:x,y计算异或结果中1的个数就是汉明距离
     */
    public int hammingDistance(int x, int y) {
        //int maxValue = Math.max(x,y);
        int ans = 0;
        int xor = x ^ y; //取异或
        //计算异或结果中1的个数
        while (xor != 0){
            xor &= xor -1;
            ans++;
        }
        return ans;
    }

}

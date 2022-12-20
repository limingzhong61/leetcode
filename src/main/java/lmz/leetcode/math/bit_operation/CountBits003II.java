package lmz.leetcode.math.bit_operation;

public class CountBits003II {
    /**
     * 动态规划——最高有效位
     * bits[i]=bits[i−highBit]+1
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) { //只有最高位一个1,更新highBit
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;
    }

    /**
     * 直接使用Brian K 算法
     */
    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    private int countOnes(int x) {
        int cnt = 0;
        while (x != 0) {
            x &= (x - 1);
            cnt++;
        }
        return cnt;
    }

    /**
     * 直接使用Java Api
     */
    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}

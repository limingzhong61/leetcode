package lmz.leetcode.math.bit_operation;

public class HammingWeight15 {
    // you need to treat n as an unsigned value

    /**
     * 位运算优化，布莱恩BK算法
     */
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }


    public int hammingWeight1(int n) {
        int cnt = 0;
        while(n != 0){
            cnt += n & 1;
            //java应该无符号右移
            n >>>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        HammingWeight15 hammingWeight15 = new HammingWeight15();

        System.out.println(hammingWeight15.hammingWeight(11));
        System.out.println(hammingWeight15.hammingWeight(11) == 3);

        System.out.println(hammingWeight15.hammingWeight(-3));
        System.out.println(hammingWeight15.hammingWeight(-3)==31);
    }
}

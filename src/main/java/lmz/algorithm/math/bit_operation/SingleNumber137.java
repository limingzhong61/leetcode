package lmz.algorithm.math.bit_operation;

/**
 * @author: limingzhong
 * @create: 2023-01-04 13:46
 */
public class SingleNumber137 {
    /**
     * leetcode: 位数统计
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int i : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += i & 1;
                i >>>= 1;
            }
        }
        int res = 0,m = 3;
        for (int i = 0; i < 32; i++) {  //将%m余下的一个比特位（1/0）加入到结果中
            res <<= 1;
            res |= counts[31 - i] % m;
            //if (counts[i] % m != 0) {
            //    res += 1 << i;
            //}
        }
        return res;
    }
}

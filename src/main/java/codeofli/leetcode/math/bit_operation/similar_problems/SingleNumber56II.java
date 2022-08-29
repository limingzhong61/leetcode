package codeofli.leetcode.math.bit_operation.similar_problems;

import codeofli.my.leetcode.TransformUtil;

public class SingleNumber56II {
    /**
     * leetcode: 遍历统计
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
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
            //if (counts[i] % m != 0) {
            //    res += 1 << i;
            //}
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber56II singleNumber56II = new SingleNumber56II();
        System.out.println(singleNumber56II.singleNumber(TransformUtil.toIntArray("[3,4,3,3]")));
    }
}

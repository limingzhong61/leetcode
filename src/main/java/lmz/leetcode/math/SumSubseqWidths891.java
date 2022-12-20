package lmz.leetcode.math;

import java.util.Arrays;

/**
 * @author: codeofli
 * @create: 2022-11-18 9:56
 */
public class SumSubseqWidths891 {
    /**
     * 1 <= nums.length <= 10^5
     */
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0;
        final int mod = (int) (1e9 + 7);
        var pow2 = new int[n];
        pow2[0] = 1;
        for (var i = 1; i < n; ++i)
            pow2[i] = pow2[i - 1] * 2 % mod; // 预处理 2 的幂次
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //只计算最左侧的值
            long val = (((long) (pow2[i] - pow2[n - i - 1]) * nums[i]) % mod + mod) % mod;
            // 注意上面有减法，ans 可能为负数
            res = (res + val) % mod;
        }
        return (int) res;
    }
}

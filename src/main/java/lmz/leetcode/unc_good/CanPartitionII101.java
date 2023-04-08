package lmz.leetcode.unc_good;

import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-04-08 17:28
 */
public class CanPartitionII101 {
    //数学定理：元素之和为奇数无法分成等和两部分；元素之和为偶数，若有部分集合之和为sum的一半，则可以分成等和两部分。
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = IntStream.of(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        //dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
        boolean[][] dp = new boolean[n][target + 1];
        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) { // j > nums[i] 才不会越界
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }

            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return  false;
    }
}

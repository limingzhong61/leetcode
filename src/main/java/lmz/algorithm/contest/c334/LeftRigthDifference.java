package lmz.algorithm.contest.c334;

/**
 * @author: limingzhong
 * @create: 2023-02-26 10:31
 */
public class LeftRigthDifference {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] ls = new int[n], rs = new int[n],res = new int[n];
        ls[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ls[i] = nums[i] + ls[i - 1];
        }
        rs[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rs[i] = nums[i] + rs[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(ls[i] - rs[i]);
        }
        return res;
    }

}

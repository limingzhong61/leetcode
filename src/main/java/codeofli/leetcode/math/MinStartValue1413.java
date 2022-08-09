package codeofli.leetcode.math;

public class MinStartValue1413 {
    /**
     * 用一个sum记录前n的数的和，如果sum<1,则补为1
     * 每次累计的补充差值的和为最小minStartValue
     */
    public int minStartValue(int[] nums) {
        int minStart = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < 1) {
                minStart += 1 - sum;
                sum = 1;
            }
        }
        //不需要补充值时为1
        return  minStart == 0 ? 1 : minStart;
    }
}

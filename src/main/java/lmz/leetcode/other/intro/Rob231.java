package lmz.leetcode.other.intro;

import lmz.my.leetcode.TransformUtil;

public class Rob231 {
    /**
     * 因为首位相连，
     * 则将nums分为nums[0,n-2],nums[1,n-1],
     * 分别用f1[i],f2[i]表示以[0,i],[1,i]结尾的最大值
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        //计算f1
        int[] f1 = new int[n];
        f1[0] = nums[0];
        f1[1] = Math.max(nums[0],nums[1]);
        int maxRob = f1[1];
        for (int i = 2; i < n - 1; i++) {
            f1[i] = Math.max(nums[i] + f1[i - 2], f1[i - 1]);
            maxRob = Math.max(maxRob, f1[i]);
        }
         if (n < 3) {
             return maxRob;
         }
        //计算f2
        int[] f2 = new int[n];
        f2[1] = nums[1];
        f2[2] = Math.max(nums[1],nums[2]);
        maxRob = Math.max(maxRob,f2[2]);
        for (int i = 3; i < n; i++) {
            f2[i] = Math.max(nums[i] + f2[i - 2], f2[i - 1]);
            maxRob = Math.max(maxRob, f2[i]);
        }
        return maxRob;
    }

    public static void main(String[] args) {
        Rob231 rob231 = new Rob231();
        testCase(rob231, "[2,3,2]", 3);
        testCase(rob231, "[1,2,3,1]", 4);
        testCase(rob231, "[1,2,3]", 3);
        testCase(rob231, "[10,1,2,3,11]", 13);
        testCase(rob231, "[2,3]", 3);
        testCase(rob231, "[1,3,1,3,100]", 103);
    }

    private static void testCase(Rob231 rob231, String s, int i) {
        System.out.println(rob231.rob(TransformUtil.toIntArray(s)));
        System.out.println(rob231.rob(TransformUtil.toIntArray(s)) == i);
    }
}

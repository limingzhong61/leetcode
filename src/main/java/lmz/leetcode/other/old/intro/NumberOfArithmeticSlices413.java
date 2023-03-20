package lmz.leetcode.other.old.intro;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

public class NumberOfArithmeticSlices413 {
    /**
     * f[i]表示以i结尾等差数组个数。
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) { //长度小于3不可能有等差数列
            return 0;
        }
        int[] f = new int[len];
        int sum = 0;
        //初始化f[2]
        sum = f[2] = nums[2] - nums[1] == nums[1] - nums[0] ? 1 : 0;
        for (int i = 3; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                f[i] += f[i - 1] + 1;
                sum += f[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlices413 numberOfArithmeticSlices413 = new NumberOfArithmeticSlices413();
        System.out.println(numberOfArithmeticSlices413.numberOfArithmeticSlices(TransformUtil.toIntArray("[1,2,3,4]")));
        System.out.println(numberOfArithmeticSlices413.numberOfArithmeticSlices(TransformUtil.toIntArray("[1,2,3,4]")) == 3);
        System.out.println(numberOfArithmeticSlices413.numberOfArithmeticSlices(TransformUtil.toIntArray("[1]")));
        System.out.println(numberOfArithmeticSlices413.numberOfArithmeticSlices(TransformUtil.toIntArray("[1]")) == 0);
    }
}

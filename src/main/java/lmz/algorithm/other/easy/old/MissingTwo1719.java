package lmz.algorithm.other.easy.old;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

public class MissingTwo1719 {
    /**
     * O(N) 时间内只用 O(1) 的空间
     * nums.length <= 30000
     * 我们记缺的两数为x、y，首先我们计算出n数的和以及实际和，差值即为a = x + y； 然后我们计算出n数的平方和与实际和，差值即为b = x * x + y * y。
     * 联立得到一元二次方程，不难得出两根分别为(a (+-) sqrt(2 * b - a * a)) / 2。
     */
    public int[] missingTwo1(int[] nums) {
        int n = nums.length + 2;
        //int sum = len * (len + 1) / 2;
        long twoSum = n * (n + 1) / 2, twoSquareSum = (1 + n) * n / 2 * (2 * n + 1) / 3;
        for (int i = 0; i < nums.length; i++) {
            twoSum -= nums[i];
            twoSquareSum -= nums[i] * nums[i];
        }
        long a = twoSum,b = twoSquareSum;
        int tmp = (int)Math.sqrt(2 * b - a * a);
        return new int[]{ (int)(a + tmp) / 2, (int)(a - tmp) / 2 };
    }

    /**
     * 根据补全后数值各不相同可知，两者必不可能同时位于 t = \left \lfloor \frac{cur}{2} \right \rfloort=⌊
     * 2
     * cur
     * ​
     *  ⌋ 的同一侧或共点（偏大、偏小或数值重复），因此我们可以计算 [1, t][1,t] 范围内的理论总和与实际总和之间的差值来确定其一（将问题转换为求解缺失一值），再结合缺失两值之和 sumsum 算得答案。
     */
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, cur = n * (1 + n) / 2;
        for (int x : nums) cur -= x;
        int sum = cur, t = cur / 2;
        cur = t * (1 + t) / 2;
        for (int x : nums) {
            if (x <= t) cur -= x;
        }
        return new int[]{cur, sum - cur};
    }

    public static void main(String[] args) {
        MissingTwo1719 missingTwo1719 = new MissingTwo1719();
        System.out.println(Arrays.toString(missingTwo1719.missingTwo(TransformUtil.toIntArray("[2,3]"))));
        System.out.println(Integer.MAX_VALUE);
    }
}

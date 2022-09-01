package codeofli.leetcode.other.primary.other;

import java.util.Arrays;

//268. 丢失的数字
public class MissingNumber268 {
    /**
     * leetcode
     * 利用高斯求和公式
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int ans = total;
        for (int num : nums) {
            ans -= num;
        }
        return ans;
    }

    /**
     * leetcode：位运算 x^i^i = x, 0^x = x,x^x =0
     * 添加[0,n]的整数，转化为在2n-1个数里找只出现一次的数
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }
        return ans;
    }


    public int missingNumber1(int[] nums) {
        int n = nums.length;
        boolean[] mark = new boolean[n + 1];
        Arrays.fill(mark, false);
        for (int i = 0; i < n; i++) {
            mark[nums[i]] = true;
        }
        for (int i = 0; i <= n; i++) {
            if (!mark[i]) {
                return i;
            }
        }
        return -1;
    }
}



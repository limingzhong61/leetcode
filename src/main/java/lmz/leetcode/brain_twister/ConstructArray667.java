package lmz.leetcode.brain_twister;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

public class ConstructArray667 {
    /**
     * 利用k=1，和k=n-1的排列组合其他情况
     * 当k = a时，由 n - k + 1个1的排列（1个差值1）和 a-1个（差值） k = n - 1的排列（1,n,2,n-1...） 组成
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int idx = 0;
        //由 n - k + 1个1的排列（1个差值1）
        for (int i = 1; i < n - k; i++) {
            res[idx++] = i;
        }
        //a-1个（差值） k = n - 1的排列（1,n,2,n-1...）
        for (int i = n - k, j = n; i <= j; i++, j--) {
            res[idx] = i;
            ++idx;
            if (i != j) {
                res[idx] = j;
                ++idx;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ConstructArray667 constructArray667 = new ConstructArray667();
        testCase(constructArray667, 3, 1, "[1, 2, 3]");
        testCase(constructArray667, 3, 2, "[1, 3, 2]");

    }

    private static void testCase(ConstructArray667 constructArray667, int n, int k, String original) {
        System.out.println(Arrays.toString(constructArray667.constructArray(n, k)));
        System.out.println(Arrays.equals(constructArray667.constructArray(n, k), TransformUtil.toIntArray(original)));
    }
}

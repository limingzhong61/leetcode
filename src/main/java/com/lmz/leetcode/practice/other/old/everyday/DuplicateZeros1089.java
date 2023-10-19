package com.lmz.leetcode.practice.other.old.everyday;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class DuplicateZeros1089 {
    /**
     * 直接暴力插入
     */
    public void duplicateZeros1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    /**
     * 双指针
     * 我们用 top 来标记栈顶位置，用 i 来标记现在需要放置的元素位置，
     * 那么我们找到原数组中对应放置在最后位置的元素位置，然后在数组最后从该位置元素往前来进行模拟放置即可。
     */
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        //先计算需要补0右边界
        int top = 0;
        int i = -1;
        while (top < n) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = n - 1;
        //结尾0需要多复制一个
        if (top == n + 1) {
            arr[j] = 0;
            i--;
            j--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = 0;
                j--;
            }
            i--;
        }
    }


    public static void main(String[] args) {
        DuplicateZeros1089 duplicateZeros = new DuplicateZeros1089();

        testCase(duplicateZeros, TransformUtil.toIntArray("[1,0,2,3,0,4,5,0]")
                , TransformUtil.toIntArray("[1,0,0,2,3,0,0,4]"));

        testCase(duplicateZeros, TransformUtil.toIntArray("[1,2,3]")
                , TransformUtil.toIntArray("[1,2,3]"));

        testCase(duplicateZeros, TransformUtil.toIntArray("[8,4,5,0,0,0,0,7]")
                , TransformUtil.toIntArray("[8,4,5,0,0,0,0,0]"));

        testCase(duplicateZeros, TransformUtil.toIntArray("[0,0,0,0,0,0,0]")
                , TransformUtil.toIntArray("[0,0,0,0,0,0,0]"));

        testCase(duplicateZeros, TransformUtil.toIntArray("[1,5,2,0,6,8,0,6,0]")
                , TransformUtil.toIntArray("[1,5,2,0,0,6,8,0,0]"));

        testCase(duplicateZeros,
                TransformUtil.toIntArray("[9,9,9,4,8,0,0,3,7,2,0,0,0,0,9,1,0,0,1,1,0,5,6,3,1,6,0,0,2,3,4,7,0,3,9,3,6,5,8,9,1,1,3,2,0,0,7,3,3,0,5,7,0,8,1,9,6,3,0,8,8,8,8,0,0,5,0,0,0,3,7,7,7,7,5,1,0,0,8,0,0]"),
                TransformUtil.toIntArray("[9,9,9,4,8,0,0,0,0,3,7,2,0,0,0,0,0,0,0,0,9,1,0,0,0,0,1,1,0,0,5,6,3,1,6,0,0,0,0,2,3,4,7,0,0,3,9,3,6,5,8,9,1,1,3,2,0,0,0,0,7,3,3,0,0,5,7,0,0,8,1,9,6,3,0,0,8,8,8,8,0]"));


    }

    private static void testCase(DuplicateZeros1089 duplicateZeros1089, int[] input, int[] output) {
        duplicateZeros1089.duplicateZeros(input);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.equals(input, output));
    }
}

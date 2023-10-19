package com.lmz.leetcode.practice.data_structure.array;

import java.util.Arrays;

public class CanBeEqual1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}

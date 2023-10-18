package com.lmz.algorithm_practice.other.old.primary.arrays;

public class PlusOne66 {

    public int[] plusOne(int[] digits) {
        //int upFlow = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] +=  1;
            if (digits[i] != 10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        //digits[0] == 0,有进位
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }
}

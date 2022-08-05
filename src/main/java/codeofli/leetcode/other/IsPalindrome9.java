package codeofli.leetcode.other;

import java.util.Arrays;

public class IsPalindrome9 {
    public boolean isPalindrome(int x) {
        if(x < 0){// 负数因为有负号，都不是
            return  false;
        }

        int[] digits = getNumberDigitArray(x);
        for(int i = 0,j = digits.length -1; i < j; i++,j--){
            if(digits[i] != digits[j]){
                return false;
            }
        }
        return  true;
    }

    /**
     *
     * @param num
     * @return 返回自然数的每一位数字形成的数组
     */
    public static int[] getNumberDigitArray(int num){
        //int 最多十位
        int[] nums = new int[11];
        //获取每一位的数字
        int index = 0;
        //获取数字位数，用do-while,防止0的情况
        do {
            nums[index++] = num % 10;
            num /= 10;
        } while (num != 0);
        return Arrays.copyOf(nums,index);
    }
}

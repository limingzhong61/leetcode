package lmz.my.math;

import java.util.Arrays;

public class Digit {

    public static int getNumberDigitSum(int num){
        int sum = 0;
        //因为0不计入统计，故不用处理num == 0的情况
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /**
     *
     * @param num
     * @return 返回自然数的每一位数字形成的int数组
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
    /**
     *
     * @param num
     * @return 返回自然数的每一位数字形成的char字符数组
     */
    public static char[] getNumberDigitCharArray(int num){
        return String.valueOf(num).toCharArray();
    }
}

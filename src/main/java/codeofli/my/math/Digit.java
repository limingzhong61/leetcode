package codeofli.my.math;

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
        return nums;
    }
}

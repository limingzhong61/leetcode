package lmz.algorithm.graph_parse_ds.find;

import lmz.my.leetcode.TransformUtil;

public class MinArray11 {
    /**
     * leetcode:二分查找
     * 分类讨论
     */
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //舍弃左半
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
                //mid 小于，mid有可能是最小值
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
    /**
     * leetcode:二分查找
     * 分类讨论
     */
    public int minArray2(int[] numbers) {
        int low = 0, high = numbers.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //舍弃左半
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
                //mid 小于，mid有可能是最小值
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    /**
     * 暴力遍历
     */
    public int minArray1(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            min = Math.min(min, numbers[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinArray11 minArray11 = new MinArray11();

        System.out.println(minArray11.minArray(TransformUtil.toIntArray("[3,4,5,1,2]")) == 1);

        System.out.println(minArray11.minArray(TransformUtil.toIntArray("[2,2,2,0,1]")) == 0);
    }

}

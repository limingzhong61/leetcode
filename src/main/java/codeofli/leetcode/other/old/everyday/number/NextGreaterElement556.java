package codeofli.leetcode.other.old.everyday.number;

import java.util.*;

public class NextGreaterElement556 {
    /**
     * 找到
     */
    public int nextGreaterElement(int n) {
        int[] digit = getNumberDigitArray(n);
        int len = digit.length;
        int minVal = digit[len - 1], minIndex = len - 1;
        //找到digit中下标i，j中的一个正序对(j>i)，i越大越好
        for (int i = len - 1; i >= 0; i--) {
            int biggerNum = Integer.MAX_VALUE;
            int biggerIndex= i;
            for (int j = i + 1; j < len; j++) {
                if(digit[j] > digit[i]){
                    if(biggerNum > digit[j]){
                        biggerNum = digit[j];
                        biggerIndex = j;
                    }
                }
            }
            if(biggerIndex != i){ //找到一个比i大一点的值
                swap(digit,i,biggerIndex);
                //后面排序变成最小
                Arrays.sort(digit,i+1,digit.length);
                break;
            }
        }
        int res = DigitArrayToNumber(digit);
        if(res == -1){ //转换失败
            return -1;
        }
        return res > n ? res : -1 ;

    }

    /**
     *
     * @param digit
     * @return -1 转换失败，因为只有正数，故可用-1表示
     */
    private int DigitArrayToNumber(int[] digit) {
        long res = 0;
        for(int i = 0; i < digit.length; i++){
            res = res * 10 + digit[i];
            if(res > Integer.MAX_VALUE){
                return -1;
            }
        }
        return (int) res;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int[] getNumberDigitArray(int num) {
        //int 最多十位
        List<Integer> numList = new ArrayList<>(11);
        //获取每一位的数字
        int index = 0;
        //获取数字位数，用do-while,防止0的情况
        do {
            numList.add(num % 10);
            num /= 10;
        } while (num != 0);
        Collections.reverse(numList);
        int size = numList.size();
        int[] res = new int[size];
        for(int i = 0; i < size; i++){
            res[i] = numList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement556 nextGreaterElement556 = new NextGreaterElement556();

        testCase(nextGreaterElement556, 12, 21);
        testCase(nextGreaterElement556, 21, -1);
        testCase(nextGreaterElement556, 12542, 14225);
        testCase(nextGreaterElement556, 2147483486, -1);
        testCase(nextGreaterElement556, 1001, 1010);
    }

    private static void testCase(NextGreaterElement556 nextGreaterElement556, int i, int i2) {
        System.out.println(nextGreaterElement556.nextGreaterElement(i));
        System.out.println(nextGreaterElement556.nextGreaterElement(i) == i2);
    }
}

package com.lmz.algorithm.other.old.sort;

import com.lmz.my.leetcode.TransformUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class MinNumber {




    /**
     * leetcode: 关键在于：(o1, o2) -> (o1 + o2).compareTo(o2 + o1)
     */
    public String minNumber(int[] nums) {
        return IntStream.of(nums).mapToObj(String::valueOf).sorted(((o1, o2) -> (o1 + o2).compareTo(o2 + o1))).collect(Collectors.joining());
    }
    /**
     * my: 基数排序
     * 如果位数不足则，末尾补该数的最后一位。如：121,12比较十位，则为121和122比较（3变成33）
     */
    public String minNumber2(int[] nums) {
        int n = nums.length;
        int maxDigitCnt = 1;
        for (int i = 0; i < n; i++) {
            maxDigitCnt = Math.max(maxDigitCnt, getDigitCnt(nums[i]));
        }

        int[][] copied = new int[n][2];
        for (int i = 0; i < n; i++) {
            copied[i][0] = copied[i][1] = nums[i];
        }
        //低位补齐
        for (int i = 0; i < n; i++) {
            int digitCnt = getDigitCnt(nums[i]);
            if (digitCnt < maxDigitCnt) {
                int rightDigit = copied[i][0] % 10;
                for (int j = digitCnt; j < maxDigitCnt; j++) {
                    copied[i][0] = copied[i][0] * 10 + rightDigit;
                }
            }
        }
        Arrays.sort(copied, (a, b) ->a[0] - b[0]);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i < n-1 && copied[i][0] != copied[i][1]){
                StringBuilder temp1 = new StringBuilder().append(copied[i][1]).append(copied[i+1][1]);
                StringBuilder temp2 = new StringBuilder().append(copied[i+1][1]).append(copied[i][1]);

                if(temp1.toString().compareTo(temp2.toString()) > 0){
                    swap(i,i+1,copied);
                }
            }
            ans.append(copied[i][1]);
        }
        return ans.toString();
    }

    private void swap(int a, int b, int[][] arr) {
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int getDigitCnt(int num) {
        int cnt = 0;
        do {
            cnt++;
            num /= 10;
        } while (num != 0);
        return cnt;
    }

    public String minNumber1(int[] nums) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }

        int base = 1;
        //int最多10位
        for (int i = 0; i < 10; i++) {
            boolean allZero = false;
            for (int j = 0; j < nums.length; j++) {
                int temp;
                //位数不足高位补齐
                if (nums[j] / base == 0) {
                    temp = getLeftDigit(nums[j]);
                } else {
                    temp = nums[j] / base % 10;
                    allZero = false;
                }
                lists.get(temp).add(nums[j]);
            }
            //高位全都是0，则排序结束
            if (allZero) {
                break;
            }
            //收集回来
            int index = 0;
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < lists.get(k).size(); j++) {
                    nums[index++] = lists.get(k).get(j);
                }
                lists.get(k).clear();
            }
            base *= 10;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i]);
        }
        return ans.toString();
    }

    private int getLeftDigit(int num) {
        int ans = 0;
        do {
            ans = num % 10;
            num /= 10;
        } while (num != 0);
        return ans;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        MinNumber minNumber = new MinNumber();

        testCase(minNumber, "[128,12]", "12128");
        testCase(minNumber, "[10,2]", "102");

        testCase(minNumber, "[3,30,34,5,9]", "3033459");

        testCase(minNumber, "[3,30,34,5,9,0]", "03033459");

        testCase(minNumber, "[0,0,10,100,303]", "0010010303");

        testCase(minNumber, "[121,12]", "12112");

        testCase(minNumber,  "[824,938,1399,5607,6973,5703,9609,4398,8247] ", "1399439856075703697382478249389609");
        //testCase(minNumber,minNumber.getClass(),"minNumber",new Object[]{TransformUtil.toIntArray("[121,12]")},new Class<?>[]{int[].class},
        //        "12112",String.class
        //       );
    }

    private static void testCase(MinNumber minNumber, String original, String result) {
        System.out.println(minNumber.minNumber(TransformUtil.toIntArray(original)));
        System.out.println(minNumber.minNumber(TransformUtil.toIntArray(original)).equals(result) );
        //System.err.println(minNumber.minNumber(TransformUtil.toIntArray(original)).equals(result) );
    }

    private static <T,R> boolean testCase(Object o,T targetClass,final String methodName,Object[] args,Class<?>[] argsTypes,
                                        Object result,R resultType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        T t = (T) o;
        Class<?> clazz = t.getClass();
        Method declaredMethod = clazz.getDeclaredMethod(methodName, argsTypes);
        R result1 = (R) declaredMethod.invoke(o, args);
        if(result1.equals(result)){
            System.out.println(Arrays.toString(args));
            System.out.println(result);
            return true;
        }
        return false;
    }

}

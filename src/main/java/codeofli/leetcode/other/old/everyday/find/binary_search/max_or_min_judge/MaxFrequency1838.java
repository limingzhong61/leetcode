package codeofli.leetcode.other.old.everyday.find.binary_search.max_or_min_judge;

import codeofli.my.leetcode.TransformUtil;

import java.util.Arrays;

public class MaxFrequency1838 {
    /**
     * 二分查找山峰
     * 因为是递增操作，最高频数的idx > 0,且呈现山峰的趋势
     */
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int max = 0;
        Arrays.sort(nums);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midF = frequency(nums, k, mid);
            int midLF = 0, midRF = 0;
            if (mid > 0) {
                midLF = frequency(nums, k, mid - 1);
            }
            if (mid < n - 1) {
                midRF = frequency(nums, k, mid + 1);
            }
            System.out.println(mid);
            if (midLF > midRF) {
                // 峰值在中间
                if(midF > midLF){
                    return midF;
                }
                max = midLF;
                high = mid - 1;
            } else { // midLF <= midRF
                // 峰值在中间
                if(midF > midLF && midF > midRF){
                    return midF;
                }
                max = midRF;
                low = mid + 1;
            }

        }
        return max;
    }

    private int frequency(int[] nums, int k, int x) {
        int cnt = 1;
        int val = nums[x];
        for (int i = x - 1; i >= 0; i--) {
            k -= val - nums[i];
            if (k < 0) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        MaxFrequency1838 maxFrequency1838 = new MaxFrequency1838();
        testCase(maxFrequency1838, "[9922,9980,9990,9922,9932,9989,9929,9938,9941,9966,9985,9906,9964,9903,9995,9963,10000,9950,9939,9985,9944,9960,9989,9977,9901,9923,9997,9971,9909,9985,9979,9906,9955,9988,9996,9995,9901,9996,9924,9967,9991,9981,9914,9933,9946,9928,9975,9990,9968,9985,9963,9927,9946,9919,9931,9955,9979,9943,9905,9918,9962,9970,9939,9901,9940,9933,9917,9988,9935,9941,9947,9971,9901,9926,9908,9969,9978,9984,9952,9945,9958,9958,9930,9923,9950,9993,9938,9976,9942,9946,9990,9951,9971,9980,9966,9944,9976,9954,9970,9984,9939,9961,9996,9993,9935,9949,9975,9952,9998,9956,9957,9949,9902,9946,9979,9904,9925,9948,9952,9961,9948,9982,9922,9958,9956]",
                1911, 75);
        //testCase(maxFrequency1838, "[1,2,4]", 5, 3);
        //testCase(maxFrequency1838, "[1,4,8,13]", 5, 2);
        //testCase(maxFrequency1838, "[3,9,6]", 2, 1);
        //testCase(maxFrequency1838, "[9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966]",
        //        3056, 73);
    }

    private static void testCase(MaxFrequency1838 maxFrequency1838, String original, int k, int x) {
        System.out.println(maxFrequency1838.maxFrequency(TransformUtil.toIntArray(original), k));
        System.out.println(maxFrequency1838.maxFrequency(TransformUtil.toIntArray(original), k) == x);
    }
}

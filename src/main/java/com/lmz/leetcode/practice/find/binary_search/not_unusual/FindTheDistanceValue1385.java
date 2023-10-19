package com.lmz.leetcode.practice.find.binary_search.not_unusual;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class FindTheDistanceValue1385 {
    /**
     * 二分查找：O(nlogn)
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int x : arr1) {
            int biggerNumber = biggerNumberByBS(arr2, x);
            int minDist = Math.abs(biggerNumber - x);
            int smallerNumber = smallerNumberByBS(arr2, x);
            minDist = Math.min(minDist, Math.abs(smallerNumber - x));
            if (minDist > d) {
                res++;
            }
        }
        return res;
    }

    /**
     * 二分查找>= x的最小值。
     */
    private int biggerNumberByBS(int[] arr2, int x) {
        int low = 0, high = arr2.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr2[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(low == arr2.length){ //有可能比数组中所有数字都大
            return arr2[arr2.length -1];
        }
        return arr2[low];
    }

    /**
     * 二分查找<= x的最大值。
     * @param arr2
     * @param x
     * @return
     */
    private int smallerNumberByBS(int[] arr2, int x) {
        int low = 0, high = arr2.length - 1;
        int pos  = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr2[mid] > x) {
                high = mid - 1;
            } else { //此时 <= x
                pos = mid;
                low = mid + 1;
            }
        }
        if(pos == -1){ //有可能比数组中所有数字都小
            return arr2[0];
        }
        return arr2[pos];
    }

    /**
     * 暴力：O(n*n)
     */
    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int x : arr1) {
            int midDist = Math.abs(arr2[0] - x);
            for (int i = 1; i < arr2.length; i++) {
                midDist = Math.min(midDist, Math.abs(arr2[i] - x));
            }
            if (midDist > d) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindTheDistanceValue1385 findTheDistanceValue1385 = new FindTheDistanceValue1385();
        testCase(findTheDistanceValue1385, "[4,5,8]", "[10,9,1,8]", 2, 2);
        testCase(findTheDistanceValue1385, "[1,4,2,3]", "[-4,-3,6,10,20,30]", 3, 2);
        testCase(findTheDistanceValue1385, "[2,1,100,3]", "[-5,-2,10,-3,7]", 6, 1);
        testCase(findTheDistanceValue1385,
                "[-803,715,-224,909,121,-296,872,807,715,407,94,-8,572,90,-520,-867,485," +
                        "-918,-827,-728,-653,-659,865,102,-564,-452,554,-320,229,36,722,-478,-247," +
                        "-307,-304,-767,-404,-519,776,933,236,596,954,464]", "[817,1,-723,187,128,577,-787,-344,-920" +
                        ",-168,-851,-222,773,614,-699,696,-744,-302,-766,259,203,601,896,-226,-844,168,126,-542,159,-833,950," +
                        "-454,-253,824,-395,155,94,894,-766,-63,836,-433,-780,611,-907,695,-395,-975,256,373,-971,-813,-154,-765" +
                        ",691,812,617,-919,-616,-510,608,201,-138,-669,-764,-77,-658,394,-506,-675,523,730,-790,-109,865,975,-226" +
                        ",651,987,111,862,675,-398,126,-482,457,-24,-356,-795,-575,335,-350,-919,-945,-979,611]", 37, 0);
    }

    private static void testCase(FindTheDistanceValue1385 findTheDistanceValue1385, String original, String original1, int d, int x) {
        System.out.println(findTheDistanceValue1385.findTheDistanceValue(TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1), d));
        System.out.println(findTheDistanceValue1385.findTheDistanceValue(TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1), d) == x);
    }

}

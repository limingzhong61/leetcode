package com.lmz.algorithm_practice.other.easy.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class FindBestValue1300 {
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        Arrays.sort(arr);
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int minDiff = sum[n] - target;
        int bestValue = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            //替换[i,n-1]的数字；
            int replaceLen = n - i;
            if(sum[i] > target){
                int nowDiff = sum[i] +  replaceLen * arr[i] - target;
                if(nowDiff < minDiff){
                    bestValue = arr[i];
                }
            }else{ // < 开始补数字
                int totalDiff = target - sum[i];
                int needVal = totalDiff / replaceLen;
                int res1 = Math.abs(totalDiff - needVal * replaceLen);
                int res2 = Math.abs(totalDiff - (needVal  + 1) * replaceLen);
                if(res2 < res1){
                    needVal = needVal + 1;
                }
                needVal = Math.min(needVal,arr[i]); //不能大于当前的值
                if(i > 0){
                    needVal = Math.max(needVal,arr[i - 1]);
                }
                int nowDiff = Math.abs(sum[i] + replaceLen * needVal - target);
                if(nowDiff  > minDiff){
                    break;
                }
                minDiff = nowDiff;
                bestValue = needVal;
            }
        }
        return bestValue;
    }

    public static void main(String[] args) {
        FindBestValue1300 findBestValue1300 = new FindBestValue1300();
        testCase(findBestValue1300, "[4,9,3]", 10, 3);
        testCase(findBestValue1300, "[60864,25176,27249,21296,20204]", 56803, 11361);
        testCase(findBestValue1300, "[2,3,5]", 10, 5);
    }

    private static void testCase(FindBestValue1300 findBestValue1300, String original, int target, int x) {
        System.out.println(findBestValue1300.findBestValue(TransformUtil.toIntArray(original), target));
        System.out.println(findBestValue1300.findBestValue(TransformUtil.toIntArray(original), target) == x);
    }
}

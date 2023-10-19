package com.lmz.leetcode.practice.other.easy.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;

public class CheckIfExist1346 {
    /**
     * 二分查找
     */
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int idx = Arrays.binarySearch(arr,0,i, arr[i] * 2);
            if(idx >= 0){
                return true;
            }
            idx = Arrays.binarySearch(arr,i+1,arr.length, arr[i] * 2);
            if(idx >= 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfExist1346 checkIfExist1346 = new CheckIfExist1346();
        System.out.println(checkIfExist1346.checkIfExist(TransformUtil.toIntArray("[-20,8,-6,-14,0,-19,14,4]")));
        System.out.println(checkIfExist1346.checkIfExist(TransformUtil.toIntArray("[-20,4]")));
    }
}

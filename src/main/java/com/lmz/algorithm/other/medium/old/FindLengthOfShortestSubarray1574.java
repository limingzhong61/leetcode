package com.lmz.algorithm.other.medium.old;

import com.lmz.my.leetcode.TransformUtil;

import java.util.*;

public class FindLengthOfShortestSubarray1574 {
    /**
     * 双指针，一共三种情况 1、开头一段+末尾一段 2、开头一段 3、末尾一段
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        ArrayList<Integer> front = new ArrayList<>(),rear = new ArrayList<>();
        int n = arr.length;
        front.add(arr[0]);
        for(int i = 1; i < n; i++){
            if(arr[i] >= arr[i - 1]){
                front.add(arr[i]);
            }else{
                break;
            }
        }
        if(front.size() == n){
            return 0;
        }
        rear.add(arr[n - 1]);
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] <= arr[i + 1]){
                rear.add(arr[i]);
            }else{
                break;
            }
        }
        Collections.reverse(rear);
        int maxLen = Math.max(front.size(),rear.size());
        for(int i = 0,j = 0; i < front.size() && j < rear.size();){
            if(front.get(i) <= rear.get(j)){
                int len = (i + 1) + (rear.size() - j);
                maxLen = Math.max(maxLen,len);
                i++;
            }else{
                j++;
            }
        }
        return n - maxLen;
    }

    public static void main(String[] args) {
        FindLengthOfShortestSubarray1574 findLengthOfShortestSubarray1574 = new FindLengthOfShortestSubarray1574();
        //testCase(findLengthOfShortestSubarray1574, "[13,0,14,7,18,18,18,16,8,15,20]", 8);
        testCase(findLengthOfShortestSubarray1574, "[2,2,2,1,1,1]", 3);
    }

    private static void testCase(FindLengthOfShortestSubarray1574 findLengthOfShortestSubarray1574, String original, int x) {
        System.out.println(findLengthOfShortestSubarray1574.findLengthOfShortestSubarray(
                TransformUtil.toIntArray(original)));
        System.out.println(findLengthOfShortestSubarray1574.findLengthOfShortestSubarray(
                TransformUtil.toIntArray(original)) == x);
    }
}

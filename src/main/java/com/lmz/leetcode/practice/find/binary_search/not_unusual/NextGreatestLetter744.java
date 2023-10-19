package com.lmz.leetcode.practice.find.binary_search.not_unusual;

public class NextGreatestLetter744 {
    /**
     * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母
     * 寻找在这一有序列表里比目标字母大的最小字母。
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(low > letters.length - 1){ //都比target小
            low = 0; //题目要求返回第一个值
        }
        return letters[low];
    }
}

package com.lmz.leetcode.practice.p.old.primary.strings;

public class ReverseString {

    public void reverseString(char[] s) {
        int n = s.length;
        for(int i =0,j=n-1; i < j ; ++i,--j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

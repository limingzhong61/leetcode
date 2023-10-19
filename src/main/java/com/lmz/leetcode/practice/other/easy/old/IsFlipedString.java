package com.lmz.leetcode.practice.other.easy.old;

public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        return (s1 + s1).contains(s2);
    }
}

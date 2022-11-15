package codeofli.leetcode.other.hard;


import codeofli.my.leetcode.TransformUtil;

import java.util.*;

public class AtMostNGivenDigitSet902 {
    /**
     * bfs,注意是否溢出
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (var s : digits) {
            int d = s.charAt(0) - '0';
            if (d <= n) {
                queue.add(d);
                list.add(d);
                ans++;
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (var d : list) {
                long nextVal = (long) poll * 10 + d;
                if (nextVal > n) { //因为是非递减，后面也超了
                    continue;
                }
                queue.add((int) nextVal);
                ans++;
            }
        }
        return ans;
    }

    //int ans = 0;
    //
    //private int search(String[] digits, int n, int cur, int start) {
    //    if(cur > n){
    //        return 0;
    //    }
    //    for (int i = 0; i < digits.length; i++) {
    //        int nextCur = cur * 10 + digits[i].charAt(0) - '0';
    //        // System.out.println( nextCur);
    //        ans++;
    //        var temp = digits[i];
    //        search(digits, n, nextCur, start + 1);
    //    }
    //    return 0;
    //}

    public static <T> void swap(T[] nums, int a, int b) {
        var temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        AtMostNGivenDigitSet902 atMostNGivenDigitSet902 = new AtMostNGivenDigitSet902();
        System.out.println(atMostNGivenDigitSet902.atMostNGivenDigitSet(TransformUtil.toStringArray("[\"1\",\"4\",\"9\"]"), 1000000000));
    }
}

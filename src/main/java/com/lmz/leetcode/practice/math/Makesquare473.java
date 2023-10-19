package com.lmz.leetcode.practice.math;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Makesquare473 {
    /**
     * 只有15个
     */
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int edgeLen = sum / 4;
        int[] edges = new int[4];
        Arrays.fill(edges, edgeLen);
        int[] pick = new int[matchsticks.length];
        Arrays.fill(pick, -1);
        // 倒序排序
        matchsticks = IntStream.of(matchsticks)          // 变为 IntStream
                .boxed()           // 装盒变为 Stream<Integer>
                .sorted(Comparator.reverseOrder()) // 按自然序相反排序
                .mapToInt(Integer::intValue)       // 变为 IntStream
                .toArray();        // 又变回 int[]
        System.out.println(Arrays.toString(matchsticks));
        return search(matchsticks, pick, edges, 0);
    }

    private boolean search(int[] matchsticks, int[] pick, int[] edges, int pickCur) {
        int cnt = 0;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] < 0) {
                return false;
            } else if (edges[i] == 0) {
                cnt++;
            }
        }
        if (pickCur == matchsticks.length) {
            //System.out.println(Arrays.toString(pick));
            //System.out.println(true);
            if (cnt == 4) {
                return true;
            } else {
                return false;
            }

        }
        for (int i = 0; i < edges.length; i++) {
            if (pick[pickCur] == -1) {
                pick[pickCur] = i;
                edges[i] -= matchsticks[pickCur];
                //System.out.println(Arrays.toString(pick));
                if (search(matchsticks, pick, edges, pickCur + 1)) {
                    return true;
                }
                pick[pickCur] = -1;
                edges[i] += matchsticks[pickCur];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Makesquare473 makesquare473 = new Makesquare473();
        testCase(makesquare473, "[1,1,2,2,2]", true);
        testCase(makesquare473, "[3,3,3,3,4]", false);
        testCase(makesquare473, "[5,5,5,5,4,4,4,4,3,3,3,3]", true);
        testCase(makesquare473, "[3,9,2,2,2,9,10,8,3,9,10,10,1,9,9]", true);
    }

    private static void testCase(Makesquare473 makesquare473, String original, boolean x) {
        System.out.println(makesquare473.makesquare(TransformUtil.toIntArray(original)));
        System.out.println(String.valueOf(
                makesquare473.makesquare(TransformUtil.toIntArray(original)) == x).toUpperCase());
    }
}

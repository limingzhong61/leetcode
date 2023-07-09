package com.lmz.algorithm.other.old.everyday;

import com.lmz.my.leetcode.TransformUtil;

import java.util.*;

public class MinimumAbsDifference1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //2 <= arr.length <= 10^5
        int len = arr.length;
        //for (int i = 0; i < len; i++) {
        //    arr[i] = Math.abs(arr[i]);
        //}
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            minAbsDiff = Math.min(minAbsDiff, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (arr[i] - arr[i - 1] == minAbsDiff) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumAbsDifference1200 minimumAbsDifference1200 = new MinimumAbsDifference1200();

        testCase(minimumAbsDifference1200, "[4,2,1,3]", "[[1,2],[2,3],[3,4]]");
        testCase(minimumAbsDifference1200, "[1,3,6,10,15]", "[[1,3]]");
        testCase(minimumAbsDifference1200, "[3,8,-10,23,19,-4,-14,27]", "[[-14,-10],[19,23],[23,27]]");
    }

    private static void testCase(MinimumAbsDifference1200 minimumAbsDifference1200, String s1, String s2) {
        System.out.println(DoubleListToStr(minimumAbsDifference1200.minimumAbsDifference(TransformUtil.toIntArray(s1))));
        System.out.println(DoubleListEquals(minimumAbsDifference1200.minimumAbsDifference(
                TransformUtil.toIntArray(s1)), TransformUtil.toDoubleArrayList(s2)));
    }

    public static boolean DoubleListEquals(List<List<Integer>> doubleList1, List<List<Integer>> doubleList2) {
        if (doubleList1.size() != doubleList2.size()) {
            return false;
        }
        for (int i = 0; i < doubleList1.size(); i++) {
            if (!doubleList1.get(i).equals(doubleList2.get(i))) {
                return false;
            }
        }
        return true;
    }


    public static String DoubleListToStr(List<List<Integer>> doubleList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (var list : doubleList) {
            sb.append(Arrays.toString(list.toArray())).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.append("]").toString();
    }
}

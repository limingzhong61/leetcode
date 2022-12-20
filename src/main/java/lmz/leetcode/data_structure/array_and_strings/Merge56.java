package lmz.leetcode.data_structure.array_and_strings;

import java.util.*;

public class Merge56 {
    /**
     * my:先排序，后合并
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size()-1);
            if (intervals[i][0] <= last[1]) { //前一个的右边界大于后一个的左边距
                last[1] = Math.max(intervals[i][1], last[1]);
            } else { //没有相交
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}

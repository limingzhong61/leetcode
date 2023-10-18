package com.lmz.algorithm_practice.data_structure.array.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge56 {
    /**
     * leetcode: 排序后合并
     */
    public int[][] merge(int[][] intervals) {
        // 按照左端点排序
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] a = intervals[i];
            int[] b = list.get(list.size() - 1);
            if(a[1] >= b[0] && b[1] >= a[0]){ //相交
                list.get(list.size() - 1)[1] = Math.max(a[1],b[1]);
            }else{
                list.add(a);
            }
        }
        return list.toArray(new int[0][0]);
    }


















    class Solution{
        /**
         * leetcode: 排序后合并
         * 按照左边短点升序排序，前面的左端点一定小于后面的左端点，则
         * 只需要比较已经加入list中的最后一个的右端点是否合法即可
         */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            //1 <= intervals.length <= 104
            int n = intervals.length;
            List<int[]> merged = new ArrayList<>(n);
            merged.add(new int[]{intervals[0][0], intervals[0][1]});
            for (int i = 1; i < n; i++) {
                int left = intervals[i][0], right = intervals[i][1];
                if (merged.get(merged.size() - 1)[1] < left) { //不相交
                    merged.add(new int[]{left, right});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
                }
            }
            //转为二维数组
            return merged.toArray(new int[merged.size()][]);
        }
    }
}

package codeofli.leetcode.data_structure.array.range;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals435 {
    /**
     * leetcode： 贪心算法，按照起点排序：选择结尾最短的，
     * 后面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的）
     * 把问题转化为最多能保留多少个区间，使他们互不重复，则按照终点排序，
     * 每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。
     * 保留右边界最小值，可以通过右边界排序
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
    /**
     * leetcode： 贪心算法，按照起点排序：选择结尾最短的，
     * 后面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的）
     * 把问题转化为最多能保留多少个区间，使他们互不重复，则按照终点排序，
     * 每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。
     */
    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int right = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            if(right <= intervals[i][0] ){ //不相交,重叠边界不算相交
                right = intervals[i][1]; //更新右边界
            }else{ //相交
                right = Math.min(right,intervals[i][1]); //取右边界最小
                res++;
            }
        }
        return res;
    }
}

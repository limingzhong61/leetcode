package codeofli.leetcode.find.binary_search.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindRightInterval436 {
    public int[] findRightInterval(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        for(int i = 0; i < n; i++){
            list.add(new int[]{intervals[i][0],intervals[i][1],i});
        }
        Collections.sort(list,(a,b)-> a[0] - b[0]);
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int idx = biggerNumberIndexByBS(list, intervals[i][1]);
            if (idx == list.size()) { //有可能比数组中所有数字都小
                res[i] = -1;
            }else {
                res[i] = list.get(idx)[2]; //记录的真实idx
            }
        }
        return res;
    }

    /**
     * 二分查找>= x的最小值下标。
     * F,T 右边界
     */
    private int biggerNumberIndexByBS(List<int[]> list, int x) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid)[0] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

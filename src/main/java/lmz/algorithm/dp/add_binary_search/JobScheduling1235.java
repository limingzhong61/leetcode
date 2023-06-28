package lmz.algorithm.dp.add_binary_search;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author: limingzhong
 * @create: 2022-10-22 9:28
 */
public class JobScheduling1235 {
    /**
     *动态规划+TreeMap
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        var sorted = new int[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(sorted, (a, b) -> a[1] - b[1]);
        TreeMap<Integer,Integer> f = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int end = sorted[i][1],start = sorted[i][0];
            var floorEntry = f.floorEntry(start);
            int floorValue = floorEntry == null ? 0 : floorEntry.getValue();
            //max 为[0,end]的最大值
            max = Math.max(max,floorValue + sorted[i][2]);
            f.put(end,max);
        }
        return max;
    }

    public static void main(String[] args) {
        JobScheduling1235 jobScheduling = new JobScheduling1235();
        System.out.println(jobScheduling.jobScheduling(TransformUtil.toIntArray("[4,2,4,8,2]"),
                TransformUtil.toIntArray("[5,5,5,10,8]"),
                TransformUtil.toIntArray("[1,2,8,10,4]")));
        System.out.println(jobScheduling.jobScheduling(TransformUtil.toIntArray("[4,2,4,8,2]"),
                TransformUtil.toIntArray("[5,5,5,10,8]"),
                TransformUtil.toIntArray("[1,2,8,10,4]")) == 18);
    }
}

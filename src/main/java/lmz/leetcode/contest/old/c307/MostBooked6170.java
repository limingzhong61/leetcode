package lmz.leetcode.contest.old.c307;

import java.util.Arrays;

public class MostBooked6170 {
    /**
     * 1 <= meetings.length <= 105
     */
    public int mostBooked(int n, int[][] meetings) {
        int len = meetings.length;
        //以结束时间为升序，结束时间相同，安装开始时间降序（会议时间更短）
        //以开始时间为升序
        Arrays.sort(meetings,(a,b) ->{
            return a[0] - b[0];
        });
        //记录开的会议次数
        int[] cnt = new int[n];
        int[] end = new int[n];
        int maxCntIdx = 0;
        for (int i = 0; i < len; i++) {
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];
            int minTime = 0;
            int minTimeIdx = 0;
            for (int k = 0; k < n; k++) {
                if(end[minTimeIdx] > end[k]){
                    minTimeIdx = k;
                }
            }
            minTime = end[minTimeIdx];
            if (minTime <= startTime) {
                end[minTimeIdx] = endTime;
            }else{ // minTime > startTime
                end[minTimeIdx] +=  endTime - startTime;
            }
            cnt[minTimeIdx]++;
        }
        for(int i = 0; i < n; i++){
            if(cnt[maxCntIdx] < cnt[i]){
                maxCntIdx = i;
            }
        }
        return maxCntIdx;
    }
}

package com.lmz.algorithm.simulation;

public class BusyStudent1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        //1 <= startTime.length <= 100
        int cnt = 0;
        int n = startTime.length;
        for(int i = 0; i < n; i++){
            if(startTime[i] <= queryTime && queryTime <= endTime[i]){
                cnt++;
            }
        }
        return cnt;
    }
}

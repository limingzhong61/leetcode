package com.lmz.algorithm.contest.old.c84;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII6174 {
    /**
     * 1 <= tasks.length <= 105
     * 1 <= tasks[i] <= 109， 用map
     * 1 <= space <= tasks.length
     */
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Long,Long> nextDay = new HashMap<>();
        long nowDay = 0;
        for(long task : tasks){
            nowDay = 1 + Math.max(nextDay.getOrDefault(task,(long)0),nowDay);
            nextDay.put(task,nowDay+space);
        }
        return nowDay;
    }
}

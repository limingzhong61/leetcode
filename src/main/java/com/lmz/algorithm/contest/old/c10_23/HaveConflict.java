package com.lmz.algorithm.contest.old.c10_23;

/**
 * @author: codeofli
 * @create: 2022-10-23 10:36
 */
public class HaveConflict {
    /**
     * 表示发生在同一天的两个闭区间时间段事件
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        int s1,e1,s2,e2;
        s1 = getTime(event1[0]);
        e1 = getTime(event1[1]);
        s2 = getTime(event2[0]);
        e2 = getTime(event2[1]);
        if(s1 > e2 || s2 >e1){ // 没有交集
            return false;
        }
        return true;
    }

    private static int getTime(String s) {
        String[] split = s.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int time = h * 60 + m;
        return time;
    }
}

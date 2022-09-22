package codeofli.leetcode.find.kth.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExclusiveTime636 {
    /**
     * 使用stack: start,end匹配
     * 1 <= n <= 100
     * 1 <= logs.length <= 500
     * 0 <= function_id < n
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new LinkedList<>();
        int[] timeSum = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int functionId = Integer.parseInt(split[0]);
            String status = split[1];
            int timestamp = Integer.parseInt(split[2]);
            if ("start".equals(status)) {
                //第3个数为记录中间有多少时间被使用了，初始为0
                stack.push(new int[]{functionId, timestamp, 0});
            } else {
                int[] starts = stack.poll();
                //assert temp != null;
                int time = timestamp - starts[1] + 1;
                int usedTime = starts[2];
                timeSum[starts[0]] += time - usedTime;
                if (!stack.isEmpty()) {  //前一个start如果存在，这它中间的这一段时间已经被当前函数（及其子函数）使用，需要累加
                    int[] pre = stack.poll();
                    pre[2] += timestamp - starts[1] + 1;
                }
            }
        }
        return timeSum;
    }
}

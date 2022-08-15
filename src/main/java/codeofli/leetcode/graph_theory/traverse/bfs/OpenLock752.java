package codeofli.leetcode.graph_theory.traverse.bfs;

import codeofli.my.leetcode.TransformUtil;

import java.util.*;

public class OpenLock752 {
    /**
     * bfs+set判重
     * 求最少旋转数，用bfs更好
     * set状态判重
     */
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        //起始位置非法
        if(set.contains("0000")){
            return  -1;
        }
        //起始位置为目标
        if ("0000".equals(target)) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        //变化的位数
        Queue<Integer> cntQueue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        cntQueue.add(0);
        set.add("0000");

        while (!queue.isEmpty()) {
            int[] status = queue.poll();
            int cnt = cntQueue.poll();
            for (int i = 0; i < 4; i++) {
                //向前移
                status[i] = (status[i] + 1) % 10;
                if (!set.contains(getIntString(status))) {
                    if (getIntString(status).equals(target)) {
                        return cnt + 1;
                    }
                    set.add(getIntString(status));
                    queue.add(Arrays.copyOf(status, status.length));
                    cntQueue.add(cnt + 1);
                }
                status[i] = (status[i] - 1 + 10) % 10;
                //向后移
                status[i] = (status[i] - 1 + 10) % 10;
                if (!set.contains(getIntString(status))) {
                    if (getIntString(status).equals(target)) {
                        return cnt + 1;
                    }
                    set.add(getIntString(status));
                    queue.add(Arrays.copyOf(status, status.length));
                    cntQueue.add(cnt + 1);
                }
                status[i] = (status[i] + 1) % 10;
            }
        }
        return -1;
    }

    private String getIntString(int[] status) {
        return "" + status[0] + status[1] + status[2] + status[3];
    }

    public static void main(String[] args) {
        OpenLock752 openLock752 = new OpenLock752();

        testCase(openLock752, "[\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"]",
                "0202", 6);

        testCase(openLock752, "[\"8888\"]", "0009", 1);

        testCase(openLock752, "[\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"]", "8888", -1);
        testCase(openLock752, "[\"0000\"]", "8888", -1);
        testCase(openLock752, "[\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"]\n", "0000", 0);
    }

    private static void testCase(OpenLock752 openLock752, String s, String s2, int i) {
        System.out.println(openLock752.openLock(TransformUtil.toStringArray(s),
                s2));
        System.out.println(openLock752.openLock(TransformUtil.toStringArray(s),
                s2) == i);
    }
}

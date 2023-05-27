package lmz.algorithm.other.old.everyday;

import lmz.my.leetcode.TransformUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinRefuelStops871 {
    private int target;

    private int startFuel;

    private int[][] stations;

    private Integer[][] memo;

    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        this.target = target;
        this.startFuel = startFuel;
        this.stations = stations;
        memo = new Integer[stations.length + 1][stations.length + 1];
        for (int i = 0; i <= stations.length; i++) {
            if (helper(stations.length, i) >= target) {
                return i;
            }
        }
        return -1;
    }

    // 考虑 [0, i - 1] 范围内的加油站，加 j 次油能够到达的最远距离
    private int helper(int i, int j) {
        if (j == 0) {
            return startFuel;
        }
        if (i < j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        // 第 i - 1 个加油站选择加油
        int res = 0;
        if (helper(i - 1, j - 1) >= stations[i - 1][0]) {
            res = helper(i - 1, j - 1) + stations[i - 1][1];
        }
        // 第 i - 1 个加油站选择不加油
        res = Math.max(res, helper(i - 1, j));
        memo[i][j] = res;
        return res;
    }

    /**
     * leetcode:dp
     * 状态定义： `dp[i][j]` 表示对于 `[0, i - 1]` 范围内的加油站，最多加 `j` 次油能够到达的最远距离。
     * 当 `i < j` 时，**这种情况其实是不存在的**，因为总共只有 `i` 个加油站却需要加 `j` 次油，设成 0 代表不存在。
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[][] dp = new int[n + 1][n + 1];
        //  j = 0;dp[i][0] = startFuel
        dp[0][0] = startFuel;
        //j加油次数0-n次
        //if (j == 0)
        for (int i = 0; i <= n; i++)
            dp[i][0] = startFuel;
        if (dp[n][0] >= target) {
            return 0;
        }
        for (int j = 1; j <= n; j++) {
            //当 `i < j` 时，**这种情况其实是不存在的**，因为总共只有 `i` 个加油站却需要加 `j` 次油，设成 0 代表不存在。
            for (int i = j; i <= n; i++) {
                //可以选择不在i-1加油站加油
                dp[i][j] = dp[i - 1][j];
                //要到达第 `i - 1` 个加油站才能选择在第 `i - 1` 个加油站加油
                if (dp[i - 1][j - 1] >= stations[i - 1][0])
                    //两者取最大
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + stations[i - 1][1], dp[i][j]);
            }
            if (dp[n][j] >= target) {
                return j;
            }
        }
        return -1;
    }

    /**
     * my：bfs暴力搜索超时
     * dp[i]<fuel,cnt>
     * <loc,fuel,cnt>表示在loc处剩余fuel升燃料并且加了cnt次。
     */
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            //不加油的情况下到达目的地
            return startFuel >= target ? 0 : -1;
        }
        //map映射便于查找loc的index；
        Map<Integer, Integer> locMap = new HashMap<>(stations.length + 1);
        for (int i = 0; i < stations.length; i++) {
            locMap.put(stations[i][0], i);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, startFuel, 0});
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int loc = item[0];
            int fuel = item[1];
            int cnt = item[2];
            // 0没在locMap中,且每次从下一个可能的站点开始，故默认0为-1
            int startIndex = locMap.getOrDefault(loc, -1) + 1;
            for (; startIndex < stations.length && loc + fuel >= stations[startIndex][0]; startIndex++) {
                int dist = stations[startIndex][0] - loc;
                int nextFuel = fuel - dist + stations[startIndex][1];
                queue.add(new int[]{stations[startIndex][0], nextFuel, cnt + 1});
                if (stations[startIndex][0] + nextFuel >= target) {
                    //res = Math.min(res,cnt);
                    //res = cnt;
                    return cnt + 1;
                }
            }
        }
        //return res == Integer.MAX_VALUE ? -1 : res;
        return -1;
    }

    public static void main(String[] args) {
        MinRefuelStops871 minRefuelStops871 = new MinRefuelStops871();
        testCase(minRefuelStops871, 1, 1, "[]", 0);
        testCase(minRefuelStops871, 100, 1, "[[10,100]]", -1);
        testCase(minRefuelStops871, 100, 10, " [[10,60],[20,30],[30,30],[60,40]]", 2);
        testCase(minRefuelStops871, 100, 50, " [[50,50]]", 1);
    }

    private static void testCase(MinRefuelStops871 minRefuelStops871, int i, int startFuel, String s, int i2) {
        System.out.println(minRefuelStops871.minRefuelStops(i, startFuel, TransformUtil.toIntMatrix(s)));
        System.out.println(minRefuelStops871.minRefuelStops(i, startFuel, TransformUtil.toIntMatrix(s)) == i2);
    }
}

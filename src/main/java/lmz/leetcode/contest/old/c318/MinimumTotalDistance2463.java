package lmz.leetcode.contest.old.c318;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author: codeofli
 * @create: 2022-11-06 11:41
 */
public class MinimumTotalDistance2463 {
    /**
     * lc: 记忆化搜索
     * 用邻项交换法可以证明，对机器人和工厂按照位置从小到大排序，那么每个工厂修复的机器人就是连续的一段了。
     * <p>
     * 定义 f(i,j)示用第 i个及其右侧的工厂，修理第 j个及其右侧的机器人，机器人移动的最小总距离。
     */
    int n, m;
    int[][] factory;
    long[][] dp;
    List<Integer> robot;
    long inf = (long)1e13;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(Integer::compareTo);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        this.factory = factory;
        this.robot = robot;
        n = factory.length;
        m = robot.size();
        dp = new long[n + 1][m + 1];
        for(int i = 0;i < n;i++)
            Arrays.fill(dp[i], inf);

        // System.out.println(Arrays.deepToString(dp));
        return f(0, 0);
    }

    private long f(int i, int j) {
        if (j == m) {   // 如果到第i个工厂时，所有的机器人都被处理完毕
            return 0;
        }
        // 如果当前状态已经计算过就直接返回
        if(dp[i][j] != inf)
            return dp[i][j];
        if (i == n - 1) { // 处理最后一个工厂
            // 当前剩余未处理的机器人个数大于最后一个工厂的limit
            // 表示无法以题目的要求处理完成，返回一个无穷大
            if (factory[i][1] < m - j) {
                return dp[i][j] = inf;
            }
            // 否则，计算剩下的机器人到最后一个工厂的距离之和
            long sum = 0;
            for (int k = j; k < m; k++) {
                sum += Math.abs(factory[i][0] - robot.get(k));
            }
            return dp[i][j] = sum;
        }
        // 当前工厂不处理任何机器人的情况
        long res = f(i + 1, j);
        // 记录当前工厂处理的机器人与工厂的距离总和
        long s = 0;
        //枚举k
        for (int k = 1; k <= factory[i][1] && j + k - 1 < m; k++) {
            s += Math.abs(factory[i][0] - robot.get(j + k -1));
            res = Math.min(res,s +  f(i + 1, j + k));
        }
        return dp[i][j] =  res;
    }

    public static void main(String[] args) {
        MinimumTotalDistance2463 minimumTotalDistance2463 = new MinimumTotalDistance2463();
        System.out.println(minimumTotalDistance2463.minimumTotalDistance(TransformUtil.toArrayList("[0,4,6]"),
                TransformUtil.toIntMatrix("[[2,2],[6,2]]")));
    }
}

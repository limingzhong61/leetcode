package codeofli.leetcode.contest.old.c318;

import codeofli.my.leetcode.TransformUtil;
import codeofli.newcoder.Main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author: codeofli
 * @create: 2022-11-06 11:41
 */
public class MinimumTotalDistance2463 {
    /**
     * lc: 记忆化搜索
     * 用邻项交换法可以证明，对机器人和工厂按照位置从小到大排序，那么每个工厂修复的机器人就是连续的一段了。
     *
     * 定义 f(i,j)示用第 i个及其右侧的工厂，修理第 j个及其右侧的机器人，机器人移动的最小总距离。
     */
    int n, m;
    int[][] factory;
    List<Integer> robot;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(Integer::compareTo);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        this.factory = factory;
        this.robot = robot;
        n = factory.length;
        m = factory.length;
        return f(0, 0);
    }

    private int f(int i, int j) {
        if(j == m){
            return 0;
        }
        int s = 0;
        int res = f(i+1,j);
        //枚举k
        for(int k = 0; k <= factory[i][1]; k++){
            s += Math.abs(factory[i][0] - robot.get(j + k));
            res = Math.min(res +s, f(i+1,j));
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumTotalDistance2463 minimumTotalDistance2463 = new MinimumTotalDistance2463();
        System.out.println(minimumTotalDistance2463.minimumTotalDistance(TransformUtil.toArrayList("[0,4,6]"),
                TransformUtil.toIntMatrix("[[2,2],[6,2]]")));
    }
}

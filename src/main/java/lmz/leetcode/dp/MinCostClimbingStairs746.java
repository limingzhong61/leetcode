package lmz.leetcode.dp;

/**
 * @author: limingzhong
 * @create: 2023-03-31 9:57
 */
public class MinCostClimbingStairs746 {
    /**
     * dp
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n+1];
        //你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
        f[0] = cost[0];
        f[1] =  Math.min(cost[0], cost[1]);
        for(int i = 2; i < n; i++){
            f[i] = Math.min(f[i-1],f[i-2])+cost[i];
        }
        return Math.min(f[n-1],f[n-2]);
    }
}

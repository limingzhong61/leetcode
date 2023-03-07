package lmz.leetcode.other.medium;

/**
 * @author: limingzhong
 * @create: 2023-03-06 8:49
 */
public class MinOperationsMaxProfit1599 {
    //public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
    //     dfs(customers, boardingCost, runningCost, 0, 0);
    //}
    //
    //private int[] dfs(int[] customers, int boardingCost, int runningCost, int last, int cur) {
    //    int total = 0;
    //    int now = 0;
    //    int customer = customers[cur];
    //    total += customer;
    //    now += customer;
    //    if (now > 4) {
    //        cnt += customer / 4;
    //        now = customer % 4;
    //    } else {
    //        cnt += 1;
    //        now = 0;
    //    }
    //}

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = 0, cnt = 0, n = customers.length;
        int total = 0;
        int now = 0;
        int nextCnt = 0;
        int nextProfit = 0;
        for (int i = 0; i < n || now > 0; i++) {
            now += i < n ? customers[i] : 0;
            if (now > 4) {
                now -= 4;
                nextProfit += 4 * boardingCost - runningCost;
            } else {
                nextProfit += now * boardingCost - runningCost;
                now = 0;
            }
            nextCnt++;
            if (nextProfit > 0) {
                maxProfit = nextProfit;
                cnt += nextCnt;
                nextProfit = nextCnt = 0;
            }
        }
        return maxProfit > 0 ? cnt : -1;
    }
}

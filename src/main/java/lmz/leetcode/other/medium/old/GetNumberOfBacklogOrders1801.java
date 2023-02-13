package lmz.leetcode.other.medium.old;

import lmz.my.leetcode.TransformUtil;

import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-01-02 10:37
 */
public class GetNumberOfBacklogOrders1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyPq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellPq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        long res = 0;
        final int MOD = (int) (1e9 + 7);
        //orders[i] = [pricei, amounti, orderTypei]
        for (var order : orders) {
            if (order[2] == 0) { // buy
                boolean zero = false;
                while (!sellPq.isEmpty() && sellPq.peek()[0] <= order[0]) {
                    if (sellPq.peek()[1] <= order[1]) {
                        int[] poll = sellPq.poll();
                        order[1] -= poll[1];
                    } else {
                        sellPq.peek()[1] -= order[1];
                        zero = true;
                        break;
                    }
                }
                if (!zero) {
                    buyPq.add(order);
                }
            } else {
                boolean zero = false;
                while (!buyPq.isEmpty() && buyPq.peek()[0] >= order[0]) {
                    if (buyPq.peek()[1] <= order[1]) {
                        int[] poll = buyPq.poll();
                        order[1] -= poll[1];
                    } else {
                        zero = true;
                        buyPq.peek()[1] -= order[1];
                        break;
                    }
                }
                if (!zero) {
                    sellPq.add(order);
                }
            }
        }
        while (!sellPq.isEmpty()) {
            // System.out.println(Arrays.toString(sellPq.peek()));
            res = (res + sellPq.poll()[1]) % MOD;
        }
        while (!buyPq.isEmpty()) {
            // System.out.println(Arrays.toString(buyPq.peek()));
            res = (res + buyPq.poll()[1]) % MOD;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        GetNumberOfBacklogOrders1801 getNumberOfBacklogOrders1801 = new GetNumberOfBacklogOrders1801();
        System.out.println(getNumberOfBacklogOrders1801.getNumberOfBacklogOrders(TransformUtil.toIntMatrix("[[26,7,0],[16,1,1],[14,20,0],[23,15,1],[24,26,0],[19,4,1],[1,1,0]]\n")));
    }
}

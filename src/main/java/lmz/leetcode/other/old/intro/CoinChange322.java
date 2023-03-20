package lmz.leetcode.other.old.intro;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange322 {
    /**
     * leetcode: 广度遍历(bfs),就是每一次从加上所有硬币,因为是广度遍历,所得到一定是可以用最少硬币达到的
     */
    public int coinChange(int[] coins, int amount) {
        //记录组成i所需的硬币数
        int[] cnt = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(cnt, -1);
        cnt[0] = 0;
        // 可能会越界
        Queue<Long> queue = new LinkedList<>();
        queue.add(0L);
        while(!queue.isEmpty()){
            long x = queue.poll();
            for(int coin : coins){
                long next = x + coin;
                if(next <= amount && cnt[(int) next] == -1){
                    cnt[(int) next] = cnt[(int) x] + 1;
                    queue.add(next);
                }
            }
        }
        return  cnt[amount];
    }
    /**
     * leetcode: 优化dp，用max而不是Integer.MAX_VALUE(因为int最大值+1 会溢出)
     * f[i]表示凑成i需要的次数
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] f = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(f, max);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //从后往前取，每次取到的都是最大的coin，次数最少
            for (int j = 0; j < coins.length &&  coins[j] <= i; j++) {
                f[i] = Math.min(f[i], f[i - coins[j]] + 1);
            }
        }
        return f[amount] == max ? -1 : f[amount];
    }

    /**
     * f[i]表示凑成i需要的次数
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] f = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(f, -1);
        for (int coin : coins) {
            if (coin <= amount) {
                f[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            if (f[i] == -1) {
                //从后往前取，每次取到的都是最大的coin，次数最少
                for (int j = 0; j < coins.length && i - coins[j] >= 0; j++) {
                    if (f[i - coins[j]] != -1) {
                        if (f[i] == -1) {
                            f[i] = f[i - coins[j]] + 1;
                        } else {
                            f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                        }
                    }
                }
            }
        }
        return f[amount];
    }

    public static void main(String[] args) {
        CoinChange322 coinChange322 = new CoinChange322();
        testCase(coinChange322, "[1, 2, 5]", 11, 3);
        testCase(coinChange322, "[2]", 3, -1);
        testCase(coinChange322, "[1]", 0, 0);
        testCase(coinChange322, "[1,2147483647]\n", 2, 2);
        testCase(coinChange322, "[1,2]\n", 2, 1);
        testCase(coinChange322, "[186,419,83,408]\n", 6249, 20);
    }

    private static void testCase(CoinChange322 coinChange322, String original, int amount, int x) {
        System.out.println(coinChange322.coinChange(TransformUtil.toIntArray(original), amount));
        System.out.println(coinChange322.coinChange(TransformUtil.toIntArray(original), amount) == x);
    }
}

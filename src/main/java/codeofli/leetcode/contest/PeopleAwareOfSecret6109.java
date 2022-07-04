package codeofli.leetcode.contest;

public class PeopleAwareOfSecret6109 {
    /**
     * leetcode:
     *动态规划。 x[n]：第n天总共有多少人记得。 y[n]：第n天有多少人在分享秘密。 z[n]：第n天(包括第n天)一共有多少人忘记了秘密。
     * 转移方程： x[n] = x[n-1]-z[n]+y[n] ：n-1记得的人以及第n天分享了多少人-第n-1天多少人忘了
     * y[n] = x[n-delay]：第n-delay天有多少人知道，这些人一定会在n天分享出来。
     * z[n] = x[n-forget]]：在n-forget天记得秘密的人，在第n天肯定全部都忘了。
     */
    final int MOD = 1000000000 + 7;

    int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] x = new long[n + 1], y = new long[n + 1], z = new long[n + 1];
        x[1] = 1;
        for(int i = 2; i <= n; i++){
            if(i - delay > 0) y[i] = x[i-delay];
            if(i - forget > 0) z[i] = x[i-forget];
            x[i] = (x[i-1]  - z[i] + y[i]) % MOD;
        }
        //需要减去第n天忘记了秘密的人
        return (int)((x[n] - z[n] + MOD) % MOD);
    }

    /**
     * leetcode: 递推
     * 记 f[i] 表示第 i 天新知道秘密的人数。根据题意有初始条件 f[1] = 1。
     * 根据题意，在第 i天，只有 (i - forget, i - delay]这个区间里新知道秘密的人才会告诉其它人。
     */

    public int peopleAwareOfSecret2(int n, int delay, int forget) {
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int left = Math.max(i - forget, 0);
            int right = Math.max(i - delay, 0);
            if (left == 0) {
                f[i] = f[1];
            }
            for (int j = left + 1; j <= right; j++) {
                f[i] = (f[i] + f[j]) % MOD;
            }
        }
        return f[n];
    }

    /**
     * my模拟:超时
     */
    public int peopleAwareOfSecret1(int n, int delay, int forget) {
        int[][] dp = new int[delay + 1][forget + 1];
        //int day = 1;
        dp[delay][forget] = 1;

        for (int day = 2; day <= n; day++) {
            int newP = 0;
            for (int i = 0; i <= delay; i++) {
                for (int j = 1; j <= forget; j++) {
                    if (dp[i][j] == 0) {
                        continue;
                    }
                    if (i == 0) {
                        dp[i][j - 1] = dp[i][j];
                        dp[i][j] = 0; //转移走了，故为0
                    } else {
                        dp[i - 1][j - 1] = dp[i][j];
                        dp[i][j] = 0;
                    }
                }
            }
            for (int j = 1; j < forget; j++) {
                //if (j - 1 != 0 && i == 0) //到day天时还没忘记了
                //{
                newP += dp[0][j];
                newP %= MOD;
                //}
            }
            dp[delay][forget] = newP % MOD;
        }
        int sum = 0;
        for (int i = 0; i <= delay; i++) {
            for (int j = 1; j <= forget; j++) {
                sum += dp[i][j];
                sum %= MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        PeopleAwareOfSecret6109 peopleAwareOfSecret6109 = new PeopleAwareOfSecret6109();

        testCase(peopleAwareOfSecret6109, 6, 2, 4, 5);
        testCase(peopleAwareOfSecret6109, 4, 1, 3, 6);
        testCase(peopleAwareOfSecret6109, 684, 18, 496, 653668527);
        testCase(peopleAwareOfSecret6109, 289,7,23, 790409951);
    }

    private static void testCase(PeopleAwareOfSecret6109 peopleAwareOfSecret6109, int i, int i2, int i3, int i4) {
        System.out.println(peopleAwareOfSecret6109.peopleAwareOfSecret(i, i2, i3));
        System.out.println(peopleAwareOfSecret6109.peopleAwareOfSecret(i, i2, i3) == i4);
    }
}

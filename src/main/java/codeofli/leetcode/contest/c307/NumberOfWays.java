package codeofli.leetcode.contest.c307;

public class NumberOfWays {
    /**
     * 109 + 7 取余
     */
    int MOD = 1000000000 + 7;

    public int numberOfWays(int startPos, int endPos, int k) {
        int a = Math.abs(endPos - startPos);
        if ((k + a) % 2 != 0 || a > k) {
            return 0;
        }
        int x = (k + a) / 2;
        return (int) ((combination(k, x)) % MOD);
    }

    /**
     * 递推式组合数学
     */
    private long combination(int m, int n) {
        int[][] f = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                f[i][j] = (f[i - 1][j] + f[i - 1][j - 1]) % MOD;
            }
        }
        return f[m][n];
    }

    public static void main(String[] args) {
        NumberOfWays numberOfWays = new NumberOfWays();
        //System.out.println(numberOfWays.cal(999, 999));
        //System.out.println(numberOfWays.cal(6, 2));
        System.out.println(numberOfWays.numberOfWays(264, 198, 68));
    }
}

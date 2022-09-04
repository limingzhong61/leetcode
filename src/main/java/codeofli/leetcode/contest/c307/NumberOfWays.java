package codeofli.leetcode.contest.c307;

public class NumberOfWays {
    /**
     * 109 + 7 取余
     */
    int MOD = 1000000000 + 7;

    public int numberOfWays(int startPos, int endPos, int k) {
        int a = endPos - startPos;
        if ((k + a) % 2 != 0) {
            return 0;
        }
        int x = (k + a) / 2;
        return (int) ((cal(k, x)) % MOD);
    }

    private long cal(int m, int n) {
        long y = 1;
        int start = Math.max(n+1,m-n+1);
        for (int i = start; i <= m; i++) {
            y *= i;
            y %= MOD;
        }
        long downY = 1;
        for (int i = 1; i <= Math.min(n+1,m-n+1)-1; i++) {
            downY *= i;
            downY %= MOD;
        }
        return y / downY;
    }

    public static void main(String[] args) {
        NumberOfWays numberOfWays = new NumberOfWays();
        //System.out.println(numberOfWays.cal(999, 999));
        //System.out.println(numberOfWays.cal(6, 2));
        System.out.println(numberOfWays.numberOfWays(264, 198,68));
    }
}

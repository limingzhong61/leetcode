package lmz.leetcode.dp.intro;

public class IntegerBreak343 {
    /**
     * 贪心
     * 尽可能的取3
     * 2 <= n <= 58
     */
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 3;
        }
        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        return res * n;
    }
}

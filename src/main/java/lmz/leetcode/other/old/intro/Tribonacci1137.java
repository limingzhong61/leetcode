package lmz.leetcode.other.old.intro;

public class Tribonacci1137 {
    /**
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * dp
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = t2;
            t2 = t0 + t1 + t2;
            t0 = t1;
            t1 = temp;
        }
        return t2;
    }
}

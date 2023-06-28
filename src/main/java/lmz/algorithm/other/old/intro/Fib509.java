package lmz.algorithm.other.old.intro;

public class Fib509 {
    /**
     * dp
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        int p = 1, q = 1;
        for (int i = 3; i <= n; i++) {
            int temp = q;
            q = p + q;
            p = temp;
        }
        return q;
    }
}

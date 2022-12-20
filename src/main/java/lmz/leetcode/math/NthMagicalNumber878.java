package lmz.leetcode.math;

/**
 * @author: codeofli
 * @create: 2022-11-22 9:21
 */
public class NthMagicalNumber878 {
    /**
     * 容斥原理 + 二分
     */
    public int nthMagicalNumber(int n, int a, int b) {
        long low = 0, high = (long) n * Math.min(a, b);
        final int mod = (int) (1e9 + 7);
        while (low <= high) {
            long mid = (high - low) / 2;
            if (getNth(mid,a,b) >= n) {
                high = mid - 1;
            }else{
                low = mid +1;
            }
            System.out.printf("%d,%d,%d",mid,low,high);
        }
        return (int) low % mod;
    }

    private long getNth(long x,int a, int b) {
        return x / a + x/ b - x / lcm(a,b);
    }

    /**
     * 最大公约数 (lowest common multiple)
     */
    public int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    /**
     * 最大公约数 (greatest common divisor)
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}

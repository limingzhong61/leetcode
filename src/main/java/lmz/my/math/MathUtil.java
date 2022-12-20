package lmz.my.math;

/**
 * @author: codeofli
 * @create: 2022-11-22 9:48
 */
public class MathUtil {
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

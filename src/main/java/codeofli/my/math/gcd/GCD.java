package codeofli.my.math.gcd;

/**
 * 最大公约数 (greatest common divisor)
 */
public class GCD {
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}

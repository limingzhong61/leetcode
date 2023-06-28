package lmz.util.solution_template.math;

/**
 * @author: limingzhong
 * @create: 2023-01-14 20:07
 */
public class Gcd {

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

package lmz.algorithm.other.old.easy;

/**
 * @author: limingzhong
 * @create: 2023-05-29 10:12
 */
public class AverageValue2455 {
    public int averageValue(int[] nums) {
        int cnt = 0, sum = 0;
        for (var x : nums) {
            if (x % 6 == 0) {
                cnt++;
                sum += x;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}

package lmz.leetcode.contest.c326;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-01-01 10:47
 */
public class MinimumPartition {
    public int minimumPartition(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        //[0,n] 结束的次数，-1无法构造
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        char[] digits = String.valueOf(k).toCharArray();
        int dLen = digits.length;
        int sum = 0;
        for (int i = 0; i < dLen; i++) {
            sum = (cs[i] - '0') + sum * 10;
            if (sum <= k) {
                f[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            sum = 0;
            int base = 1;
            for (int j = i; j > i - dLen && j - 1 >= 0; j--) {
                sum = (cs[j] - '0') * base + sum;
                if (f[j - 1] != Integer.MAX_VALUE && sum <= k) {
                    f[i] = Math.min(f[i], f[j - 1] + 1);
                }
                base *= 10;
            }
        }
        return f[n - 1] != Integer.MAX_VALUE ? f[n - 1] : -1;
    }

    public static void main(String[] args) {
        MinimumPartition minimumPartition = new MinimumPartition();
        //System.out.println(minimumPartition.minimumPartition("165462"
        //        , 60));
        //System.out.println(minimumPartition.minimumPartition("1"
        //        , 1));
        System.out.println(minimumPartition.minimumPartition("1829727651",
                10));
    }
}

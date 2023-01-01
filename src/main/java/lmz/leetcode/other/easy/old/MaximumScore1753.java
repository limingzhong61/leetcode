package lmz.leetcode.other.easy.old;

import java.util.Arrays;

/**
 * @author: codeofli
 * @create: 2022-12-21 14:09
 */
public class MaximumScore1753 {
    public int maximumScore(int a, int b, int c) {
        int ans = 0;
        int[] rec = new int[]{a, b, c};
        Arrays.sort(rec);
        while (rec[0] != 0 || rec[1] != 0) {
            ans++;
            rec[1]--; rec[2]--;
            Arrays.sort(rec);
        }
        return ans;
    }
}

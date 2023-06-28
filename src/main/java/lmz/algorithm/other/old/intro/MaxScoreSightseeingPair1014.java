package lmz.algorithm.other.old.intro;

public class MaxScoreSightseeingPair1014 {
    /**
     * dp+公式拆分
     * leetcode: a[i]+a[j]+i-j可以变为 a[i]+i+a[j]-j
     * 由于a[j]-j固定不变，则max{a[i]+i+a[j]-j}->max{a[i]+i}
     * 则用一个max维护即可
     */
    public int maxScoreSightseeingPair(int[] values) {
        //2 <= values.length <= 5 * 104
        int n = values.length;
        int maxLeft = values[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, maxLeft + values[i] - i);
            maxLeft = Math.max(maxLeft, values[i] + i);
        }
        return res;
    }
}

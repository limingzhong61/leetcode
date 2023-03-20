package lmz.leetcode.find.binary_search.max_or_min_judge;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

public class MinSpeedOnTime1870 {
    /**
     * 二分查找尝试, flase,true;右边界
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        //生成的测试用例保证答案不超过 107
        int max = 10000000;
        int low = 1, high = 10000000;
        while (low <= high) {
            int mid = (high + low) >> 1;
            if (check(dist, hour, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // 有可能所有速度都不行
        return low > max ? -1 : low;
    }

    private boolean check(int[] dist, double hour, double x) {
        double sum = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            sum += Math.ceil(dist[i] / x);
            if (sum > hour) {
                return false;
            }
        }
        return sum + dist[dist.length - 1] / x <= hour;
    }

    public static void main(String[] args) {
        MinSpeedOnTime1870 minSpeedOnTime1870 = new MinSpeedOnTime1870();
        System.out.println(minSpeedOnTime1870.minSpeedOnTime(TransformUtil.toIntArray("[1,3,2]"), 2.7));
        System.out.println(minSpeedOnTime1870.minSpeedOnTime(TransformUtil.toIntArray("[1,3,2]"), 2.7) == 3);
        System.out.println(minSpeedOnTime1870.minSpeedOnTime(TransformUtil.toIntArray("[1,1,100000]"), 2.01));
        System.out.println(minSpeedOnTime1870.minSpeedOnTime(TransformUtil.toIntArray("[1,1,100000]"), 2.01) == 10000000);

    }
}

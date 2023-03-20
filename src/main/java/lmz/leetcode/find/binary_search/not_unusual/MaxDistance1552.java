package lmz.leetcode.find.binary_search.not_unusual;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;

public class MaxDistance1552 {
    /**
     * 二分查找:
     * 在上下边界内找找到符合条件的最大值(左边界)
     * low 下边界为可能的最小距离
     * high 最长距离
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        //2 <= n <= 10^5
        int minDist = position[1] - position[0];    // 记录最小间隔
        int n = position.length;
        for (int i = 2; i < n; i++) {
            minDist = Math.min(minDist, position[i] - position[i - 1]);
        }
        int maxDist = position[n - 1] - position[0];// 最大间隔
        int low = minDist, high = maxDist / (m - 1);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(position, m, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean check(int[] nums, int m, int x) {
        int cnt = 0;
        int target = nums[0] + x;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                cnt++;
                target = nums[i] + x;
            }
        }
        return cnt >= m - 1;
    }

    public static void main(String[] args) {
        MaxDistance1552 maxDistance1552 = new MaxDistance1552();
        System.out.println(maxDistance1552.maxDistance(TransformUtil.toIntArray("[79,74,57,22]"), 4));
    }
}

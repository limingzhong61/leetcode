package lmz.algorithm.other.old.easy;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-03-17 8:24
 */
public class AnswerQueries {
    /**
     * 1 <= n, m <= 1000
     * 1 <= nums[i], queries[i] <= 10^6
     * 子序列，不是子数组
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int m = queries.length, n = nums.length;
        int[] res = new int[m];
        for (int k = 0; k < m; k++) {
            int query = queries[k];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if(sum > query){
                    break;
                }
                res[k] = i;
            }

        }
        return res;
    }

    /**
     * 1 <= n, m <= 1000
     * 1 <= nums[i], queries[i] <= 10^6
     * 前缀和（递增）+二分查找
     */
    public int[] answerQueries2(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int k = 0; k < m; k++) {
            int query = queries[k];
            System.out.printf("%d--------------\n", query);
            for (int i = 1; i <= n; i++) {
                int x = preSum[i] - query;
                if (x < 0) { // 前缀和更小
                    res[k] = Math.max(res[k], i);
                } else {
                    int idx = bs(preSum, i, x);
                    if (idx >= i) {
                        continue;
                    }
                    int len = i - idx;
                    res[k] = Math.max(res[k], len);
                    System.out.printf("idx=%d,",idx);
                }
                System.out.printf("%d,%d,%d,%d\n", i, preSum[i], x, res[k]);
            }

        }
        return res;
    }


    /**
     * >=x 的最小 idx
     * F,F,F,T,T,T
     *
     * @param preSum
     * @param x
     */
    private int bs(int[] preSum, int len, int x) {
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        AnswerQueries answerQueries = new AnswerQueries();
        System.out.println(Arrays.toString(answerQueries.answerQueries(TransformUtil.toIntArray("[4,5,2,1]"),
                TransformUtil.toIntArray("[3,10,21]"))));
    }
}

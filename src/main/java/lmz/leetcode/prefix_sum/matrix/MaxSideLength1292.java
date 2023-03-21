package lmz.leetcode.prefix_sum.matrix;

import lmz.my.leetcode.TransformUtil;

public class MaxSideLength1292 {
    /**
     * 二维前缀和，二分查找
     */
    public int maxSideLength(int[][] mat, int threshold) {
        //1 <= m, n <= 300
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + mat[i - 1][j - 1] - sum[i - 1][j - 1];
            }
        }
        int maxLen = Math.min(m, n);
        int[] maxLenSum = new int[maxLen + 1];
        for (int len = 1; len <= maxLen; len++) {
            maxLenSum[len] = Integer.MAX_VALUE;
            for (int i = 0; i + len - 1 < m; i++) {
                for (int j = 0; j + len - 1 < n; j++) {
                    int bottom = i + len - 1, right = j + len - 1;
                    int areaSum = sum[bottom + 1][right + 1] - sum[bottom + 1][j]
                            - sum[i][right + 1] + sum[i][j];
                    maxLenSum[len] = Math.min(maxLenSum[len],areaSum);
                }
            }
        }
        int idx = smallerNumberIndexByBS(maxLenSum, threshold);
        if (idx == -1) { //有可能比数组中所有数字都小
            return 0;
        }
        return idx;
    }

    /**
     * 二分查找<= x的最大值下标，。
     *T, F,左边界
     */
    private int smallerNumberIndexByBS(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else { //此时 <= key
                pos = mid;
                low = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        MaxSideLength1292 maxSideLength1292 = new MaxSideLength1292();
        System.out.println(maxSideLength1292.maxSideLength(TransformUtil.toIntMatrix(
                " [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]"), 4));
    }
}

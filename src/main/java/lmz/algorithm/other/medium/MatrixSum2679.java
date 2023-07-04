package lmz.algorithm.other.medium;


import java.util.PriorityQueue;

/**
 * @author: limingzhong
 * @create: 2023-07-04 10:17
 */
public class MatrixSum2679 {
    public int matrixSum(int[][] nums) {
        int row = nums.length, col = nums[0].length, ans = 0;
        for (int k = 0; k < col; k++) {
            //0 <= nums[i][j] <= 103
            int max = -1;
            for (int i = 0; i < row; i++) {
                int maxColIdx = 0;
                for (int j = 1; j < col; j++) {
                    if (nums[i][j] > nums[i][maxColIdx]) {
                        maxColIdx = j;
                    }
                }
                max = Math.max(max, nums[i][maxColIdx]);
                nums[i][maxColIdx] = -1; // 选取标记
            }
            ans += max;
        }
        return ans;
    }
}

package lmz.algorithm.divide_and_conquer;

import java.util.Arrays;

public class SearchMatrix240 {

    /**
     * leetcode:分治法。
     *
     * 左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
     * 若左下角元素等于目标，则找到
     * 若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
     * 若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
     * 若最后矩阵减小为空，则说明不存在
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        //    1 <= n, m <= 300
        int m = matrix.length,n = matrix[0].length;
        //左下角坐标
        int left = 0,bottom = m-1;
        while(bottom >= 0 && left < n){
            if(matrix[bottom][left] == target){
                return  true;
            }else if(matrix[bottom][left] > target){ //舍弃最后一行 >= matrix[bottom][left]
                bottom--;
            }else{ //matrix[bottom][left] < target,舍弃第一列 <= matrix[bottom][left]
                left++;
            }
        }
        return false;
    }

    /**
     * 逐行二分查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            //int index = search(row, target);
            int index = Arrays.binarySearch(row,target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}

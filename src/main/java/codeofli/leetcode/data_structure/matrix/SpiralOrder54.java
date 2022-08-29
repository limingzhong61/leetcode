package codeofli.leetcode.data_structure.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {
    //转圈按层遍历-四个方向
    // 代码优化，判断条件由元素个数决定
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int size = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (size > 0) {
            // left move
            for (int i = left; i <= right && size > 0; i++) {
                res.add(matrix[top][i]);
                size--;
            }
            top++;
            // down move
            for (int i = top; i <= bottom && size > 0; i++) {
                res.add(matrix[i][right]);
                size--;
            }
            right--;
            // right move
            for (int i = right; i >= left && size > 0; i--) {
                res.add(matrix[bottom][i]);
                size--;
            }
            bottom--;
            if (left > right || top > bottom) {
                break;
            }
            // up move
            for (int i = bottom; i >= top && size > 0; i--) {
                res.add(matrix[i][left]);
                size--;
            }
            left++;
        }
        return res;
    }
    //转圈按层遍历-四个方向
    public List<Integer> spiralOrder1(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            // left move
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > bottom) {
                break;
            }
            // down move
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right || top > bottom) {
                break;
            }
            // right move
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (left > right || top > bottom) {
                break;
            }
            // up move
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > bottom) {
                break;
            }
        }
        return res;
    }
}

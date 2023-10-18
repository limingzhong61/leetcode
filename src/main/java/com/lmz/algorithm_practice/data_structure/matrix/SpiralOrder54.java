package com.lmz.algorithm_practice.data_structure.matrix;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0,y = 0;
        int low = 0,high = matrix.length - 1,left = 0,right = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while(true){
            for(int i = left; i <= right; i++){
                System.out.println(right);
                System.out.println(i);
                ans.add(matrix[i][low]);
            }
            low++;
            if(low > high || left > right) break;
            for(int i = low + 1; i < high; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(low > high || left > right) break;
            for(int i = left; i < right; i++){
                ans.add(matrix[high][i]);
            }
            high--;
            if(low > high || left > right) break;
            for(int i = low + 1; i < high; i++){
                ans.add(matrix[i][left]);
            }
            left++;
            if(low > high || left > right) break;
        }
        return ans;
    }

    class Solution{
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
            int x = 0,y = 0;
            int low = 0,high = matrix.length - 1,left = 0,right = matrix[0].length - 1;
            List<Integer> ans = new ArrayList<>();
            while(true){
                for(int i = left; i <= right; i++){ // 右移动
                    ans.add(matrix[low][i]);
                }
                low++;
                if(low > high || left > right) break;
                for(int i = low; i <= high; i++){ // 下移动
                    ans.add(matrix[i][right]);
                }
                right--;
                if(low > high || left > right) break;
                for(int i = right; i >= left; i--){  // 左移动
                    ans.add(matrix[high][i]);
                }
                high--;
                if(low > high || left > right) break;
                for(int i = high; i >= low; i--){ // 上移动
                    ans.add(matrix[i][left]);
                }
                left++;
                if(low > high || left > right) break;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        SpiralOrder54 spiralOrder54 = new SpiralOrder54();
        System.out.println(spiralOrder54.spiralOrder(TransformUtil.toIntMatrix("[[1,2,3],[4,5,6],[7,8,9]]")));
    }
}

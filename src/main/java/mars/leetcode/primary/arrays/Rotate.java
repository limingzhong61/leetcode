package mars.leetcode.primary.arrays;

import java.util.Arrays;

public class Rotate {
    /**
     * my solution
     *请不要 使用另一个矩阵来旋转图像。
     * 环状替换：1<->2,1转了90，2<->3,2转了90，最后3<->4,3,4转了90
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        //(n+1)/2 包括中间的也要换
        // 外圈替换成功，缩为内圈
        for(int start = 0,end = n-1;start <= end; start++,end--){
            // if(length == 1){// 1*1不需要转
            //     continue;
            // }
            //4个角特殊处理
            swap(matrix,start,start,start,end);
            swap(matrix,start,start,end,end);
            swap(matrix,start,start,end,start);
            //余下[start+1,end-1]
            for(int i = start+1; i <end; i++){
                // 距离
                int distance = i-start;
                swap(matrix,start,i,i,end);
                swap(matrix,start,i,end,end-distance);
                swap(matrix,start,i,end-distance,start);
                //swap(matrix,0,1,n-1,n-1-i);
            }
            // for(int i = 0; i< n; i++){
            //     System.out.println(Arrays.toString(matrix[i]));
            // }
        }

    }

    public  void  swap(int[][] matrix,int i,int j,int a,int b){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = temp;
    }

    //

    /**
     * 方法二：原地旋转
     * newMatrix[row][n-1-col] = matrix[row][col];
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                newMatrix[j][n-1-i] = matrix[i][j];
            }
        }
        //还原数组
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    /**
     * 方法2：使用辅助数组
     * 环状替换：1<->2,1转了90，2<->3,2转了90，最后3<->4,3,4转了90
     */
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2;i++){
            for(int j = 0; j < (n+1)/2; j++){
                int temp = matrix[i][j];
                //matrix[i][j] = matrix[j][n-1-i]
                matrix[i][j] = matrix[n-1-j][i] ;
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    /**
     * 方法三：用翻转代替旋转
     * 结论：水平+主对角线翻转（转置）=旋转90°
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for(int i = 0; i < n/2;i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        //主对角线翻转（转置）
        for(int i = 0; i < n;i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

package lmz.leetcode.data_structure;

public class MatrixReshape566 {
    /**
     * 一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
     *如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRow = mat.length,matCol = mat[0].length;
        if(matRow * matCol != r *c){
            return mat;
        }
        int[][] newMatrix = new int[r][c];
        int cnt = 0;
        for (int i = 0; i < matRow; i++) {
            for (int j = 0; j < matCol; j++) {
                newMatrix[cnt / c][cnt % c] = mat[i][j];
                cnt++;
            }
        }
        return newMatrix;
    }
}

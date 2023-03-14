package lmz.leetcode.other.medium;

/**
 * @author: limingzhong
 * @create: 2023-03-14 15:27
 */
public class RestoreMatrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowLen = rowSum.length,colLen = colSum.length;
        int[][] res = new int[rowLen][colLen];
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                int min = Math.min(rowSum[i],colSum[j]);

            }
        }
    }
}

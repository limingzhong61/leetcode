package exam.t1;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 得到画布上白色小方格的个数
     *
     * @param rects int整型二维数组
     * @return int整型
     */
    public int getWhiteCounts(int[][] rects) {
        boolean[][] matrix = new boolean[101][101];
        for (int[] rect : rects) {
            int x1 = Math.min(rect[0],rect[2]);
            int y1 = Math.min(rect[1],rect[3]);
            int x2 = Math.max(rect[0],rect[2]);
            int y2 = Math.max(rect[1],rect[3]);

            // 左上角为当前格子标记
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    matrix[i][j] = !matrix[i][j];
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(!matrix[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
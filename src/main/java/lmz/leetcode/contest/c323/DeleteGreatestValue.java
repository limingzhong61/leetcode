package lmz.leetcode.contest.c323;

import lmz.my.leetcode.TransformUtil;

public class DeleteGreatestValue {
    /**
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 50
     * 1 <= grid[i][j] <= 100
     */
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length ,n = grid[0].length, res = 0;
        for(int k = 0; k < n; k++){
            int max = -1;
            for(int i = 0; i < m ; i++){
                int maxIdx = 0;
                for(int j = 0; j < n; j++){
                    if(grid[i][j] != -1 && grid[i][j] > grid[i][maxIdx]){
                        maxIdx = j;
                    }
                }
                System.out.printf("%d\n",grid[i][maxIdx]);
                max = Math.max(max,grid[i][maxIdx]);
                grid[i][maxIdx] = -1;
            }
            System.out.printf("%d\n",max);
            res += max;
        }
        return res;
    }

    public static void main(String[] args) {
        DeleteGreatestValue deleteGreatestValue = new DeleteGreatestValue();
        System.out.println(deleteGreatestValue.deleteGreatestValue(TransformUtil.toIntMatrix("[[1,2,4],[3,3,1]]")));
    }
}

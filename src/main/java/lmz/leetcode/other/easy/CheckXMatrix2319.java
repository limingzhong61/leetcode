package lmz.leetcode.other.easy;

/**
 * @author: limingzhong
 * @create: 2023-01-31 10:50
 */
public class CheckXMatrix2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || i + j == n - 1){
                    if(grid[i][j] == 0){
                        return  false;
                    }
                }else{
                    if(grid[i][j] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

package lmz.algorithm.contest.old.c303;

import java.util.*;

public class EqualPairs6125 {
    /**
     * n == grid.length == grid[i].length
     * 1 <= n <= 200
     */
    public int equalPairs(int[][] grid) {
        Map<String,Integer> rowMap = new HashMap<>();
        //Set<String> colSet = new HashSet<>();
        int n = grid.length;
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n;j++){
                sb.append(grid[i][j]).append("-");
            }
            rowMap.put(sb.toString(),rowMap.getOrDefault(sb.toString(),0)+1);
        }
        int res = 0;
        for(int j = 0; j < n; j++){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n;i++){
                sb.append(grid[i][j]).append("-");
            }
            res += rowMap.getOrDefault(sb.toString(),0);
        }
        return res;
    }

    public static void main(String[] args) {
        //new
    }
}

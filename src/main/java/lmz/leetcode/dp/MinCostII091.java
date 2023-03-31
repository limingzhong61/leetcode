package lmz.leetcode.dp;

/**
 * @author: limingzhong
 * @create: 2023-03-31 10:42
 */
public class MinCostII091 {
    public int minCost(int[][] costs) {
        //1 <= n <= 100
        int n = costs.length,m = costs[0].length;
        var f = new int[n][m];
        for(int i =0; i < m;i++){
            f[0][i] = costs[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                f[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < m; k++){
                    if(j != k){
                        f[i][j] = Math.min(f[i-1][k],f[i][j]);
                    }
                }
                f[i][j] += costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0; i < m;i++){
            min = Math.min(min,f[n-1][i]);
        }
        return min;
    }
}

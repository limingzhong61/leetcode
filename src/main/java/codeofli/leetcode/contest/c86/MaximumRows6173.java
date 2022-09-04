package codeofli.leetcode.contest.c86;

public class MaximumRows6173 {
    /**
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 12
     * 范围不大，暴力枚举
     */
    int m, n;

    public int maximumRows(int[][] mat, int cols) {
         m = mat.length;
         n = mat[0].length;
        search(mat,0, cols);
        return res;
    }

    int[] b = new int[n];
    int res = 0;
    private void search(int[][] mat,int cur , int cols) {
        if(cur == n){
            if(cols == 0){
                res = Math.max(res,judge(mat));
                return;
            }
            return ;
        }
        b[cur] = 1;
        search(mat,cur+1,cols-1);
        b[cur] = 0;
        search(mat,cur+1,cols);
    }

    private int judge(int[][] mat) {
        int cnt = 0;
        for(int i = 0; i < m; i++){
            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && b[j] != 1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                cnt++;
            }
        }
        return cnt;
    }
}

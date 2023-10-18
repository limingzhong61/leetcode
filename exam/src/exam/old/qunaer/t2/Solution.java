package exam.old.qunaer.t2;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param paths int整型二维数组 二维矩阵代表的雪球从山顶到山脚路径
     * @return int整型
     */
    public int minPath (int[][] paths) {
        for(int i = 1; i < paths[0].length; i++){
            paths[0][i] += paths[0][i-1];
        }

        for(int i = 1; i < paths.length; i++){
            paths[i][0] += paths[i-1][0];
        }

        for(int i = 1; i < paths.length; i++){
            for(int j = 1; j < paths[i].length; j++){
                paths[i][j] += Math.min(paths[i-1][j], paths[i][j-1]);
            }
        }
        return paths[paths.length-1][paths[0].length-1];
    }
}
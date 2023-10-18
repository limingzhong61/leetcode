package exam.old.qunaer.t3;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 动态规划实现
     * @param N int整型
     * @param a int整型
     * @param b int整型
     * @return double浮点型
     */
    public double percent (int N, int a, int b) {
        // write code here
        // f[i][j] 表示 第 i轮 j 的概率
        double[][] f  = new double[b + 1][b+1];
        for(int i = 1; i <= N; i++){
            f[1][i] = 1.0 / 9;
        }
        for(int i = 1; i <= b; i++){
            for(int j = 1; j <= b; j++){
                for(int x = 1;  x <= j; x++){
                    for(int  y = 1; y <= j; y++){
                        if(x + y == j){
                            f[i][j] += f[i-1][x] * f[i-1][y];
                        }
                    }
                }
            }
        }
        double pos = 0;
        for(int i = 1; i <= b; i++){
            for(int j = a; j <= b; j++){
                pos += f[i][j];
            }

        }

        return pos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.percent(10, 17, 21));
    }
}

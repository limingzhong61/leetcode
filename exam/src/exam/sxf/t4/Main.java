package exam.sxf.t4;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        int m = in.nextInt();
        int n = in.nextInt();
        if(k < m + n ){
            System.out.println(0);
            return;
        }
        long[][] f = new long[m+1][n+1];
        for(int i = 0; i <= m; i++){
            f[i][0] = 1;
        }
        for(int i = 0; i <= n; i++){
            f[0][i] = 1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        System.out.println(f[m][n]);
    }
}
package exam.old.meituan.t5;


import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        long ans = 0;
        long mod = 1_000_000_000 + 7;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                dp[i][j] = dp[i][j-1] + a[i] ^ a[j];
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        // 表示 f[j] 表示每i层 i,j的异或和
        long[] f = new long[n];
        for(int i = n - 1; i >= 0; i--){
            f[i] = 0;
            for(int j = i-1; j >= 0; j--){
                //long t = 0;
                //for(int k = i; k < j; k++){
                //    t = (t +(a[k] ^ a[j]) ) % mod;
                //}
                f[j] = (f[j+1] + dp[j][i]) % mod;
                System.out.printf("%d,%d,%d\n",i,j,f[j]);
                ans = (ans + f[j]) % mod;
            }

        }
        System.out.println(ans);
    }
}

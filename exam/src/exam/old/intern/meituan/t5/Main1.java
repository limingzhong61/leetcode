package exam.old.intern.meituan.t5;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        long ans = 0;
        long mod = 1_000_000_000 + 7;
        // 表示 f[i][j] 表示i-j 的异或和
        //long[][] f = new long[n][n];
        for(int i = 0; i < n; i++){
            long f = a[i];

            for(int j = i+1; j < n; j++){
                f ^= a[j];
                System.out.printf("%d,%d,%d\n",i,j,f);
                ans = (ans + f) % mod;
            }
        }
        System.out.println(ans);
    }
}

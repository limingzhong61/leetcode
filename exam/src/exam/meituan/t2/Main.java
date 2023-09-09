package exam.meituan.t2;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + a[i - 1];
        }

        for(int i = 0; i < n; i++){
            preSum[i] -= a[i];
        }

        long[] sufSum = new long[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + a[i + 1];
        }

        long ans = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(preSum[i] >= 0){
                ans = Math.min(ans, preSum[i] + sufSum[i]);
            }
        }
        if(ans == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
}

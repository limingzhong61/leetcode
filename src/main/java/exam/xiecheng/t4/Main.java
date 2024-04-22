package exam.xiecheng.t4;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long p = 1;
        int max = 0;

        //int n = in.nextInt();
        //int[] a = new int[n];
        //for (int i = 0 ; i < n; i++) {
        //    a[i] = in.nextInt();
        //    max = Math.max(a[i], max);
        //}

        int[] a = new int[]{1,2,3,4,5};
        int n = a.length;
        max = 5;

        long[] f = new long[max+1];
        f[1] = 1;
        for (int j = 2; j <= max; j++) {
            f[j] = f[j-1] * j;
        }
        for (int i = 0; i < n; i++) {
            p *= f[a[i]];
        }
        int ans = 0;
        for (int i = 1; (long) i * i <= p; i++) {
            if (p % i == 0) {
                ans += 2;
                if (i == p / i) ans--;
                 System.out.printf("%d,%d\n", i, p / i);
            }
        }
        // System.out.println(p);
        System.out.println(ans);
    }
}

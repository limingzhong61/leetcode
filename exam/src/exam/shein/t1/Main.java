package exam.shein.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long total = 100;
        final int max = 150;
        long startTime = 0;
        long ans = 0;

        long[][] reqs = new long[n][2];
        for (int i = 0; i < n; i++) {
            reqs[i][0] = in.nextInt();
            reqs[i][1] = in.nextInt();
        }
        Arrays.sort(reqs, (a, b) -> (int)(a[0] - b[0]));


        for (int i = 0; i < n; i++) {
            long time = reqs[i][0];
            long cnt = reqs[i][1];

            long diffTime = time - startTime;
            total = Math.min(max, total + diffTime / 100 * 10);
            if (cnt > total) {
                ans += cnt - total;
            }
            //System.out.println(ans);
            startTime = time;
        }
        System.out.println(ans);
    }
}

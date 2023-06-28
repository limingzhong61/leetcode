package exam.old.xiaohongshu.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();
        if (n == 3)
            System.out.println(1);
        else {
            char[] cs = new char[n];
            dfs(n, cs, 0);
            System.out.println(res);
        }
    }

    static long res = 0;

    private static void dfs(int n, char[] cs, int cur) {
        if (cur >= n) {
            char[] cc = new char[]{'r', 'e', 'd'};
            int startIdx = 0;
            long cnt = 0;
            for (int len = 3; len <= n; len++) {
                for (int i = 0; i < len; i++) {
                    if (startIdx < 3 && cs[i] == cc[startIdx]) {
                        startIdx++;
                    }
                    if (startIdx == 3) {
                        cnt++;
                    }
                }
            }
            res += cnt;
            if (cnt > 0)
                System.out.println(res);
            return;
        }
        cs[cur] = 'r';
        dfs(n, cs, cur + 1);
        cs[cur] = 'e';
        dfs(n, cs, cur + 1);
        cs[cur] = 'd';
        dfs(n, cs, cur + 1);
    }
}

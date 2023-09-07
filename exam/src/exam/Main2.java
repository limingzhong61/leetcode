package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 6
 * 2 2 4 5 1 2
 * <p>
 * 3
 * 1 1 1
 * <p>
 * 2
 * 10 100
 */
public class Main2 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        char[] cs = s.toCharArray();
        int n = cs.length;
        int left = 0,ans = 0;
        for (int i = 0; i <= n - 3; i++) {
            if (s.startsWith("110", i)) {
                ans = Math.max(ans, i + 1 - left + 1);
                left = i + 1;
            }

        }
        ans = Math.max(ans, n - left);
        System.out.println(ans);
    }
}
/**
 1101010110010110
 8
 110
 2
 110000
 */
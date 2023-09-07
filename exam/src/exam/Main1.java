package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
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
public class Main1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int i = 0; i < t; i++) {
            int l = cin.nextInt(), r = cin.nextInt(), m = cin.nextInt();
            int lNeed = Math.min(m - l,r), rNeed = Math.max(m - r,l);
            int lCnt = (Math.max(lNeed, l) - Math.min(lNeed, l) + 1) / 2;
            int rCnt = 0;
            if (rNeed > 0)
                rCnt = (r - rNeed + 1) / 2;
            System.out.println(Math.max(lCnt, rCnt));
        }
    }
}
/**
  4
3 7 9
1 2 4
1 11 12
12345 98765 56789
 */
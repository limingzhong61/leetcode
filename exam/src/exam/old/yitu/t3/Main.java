package exam.old.yitu.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        char[] cs = s.toCharArray();
        int n = cs.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j + 1 < n && (cs[j] == 'Y' && (cs[j + 1] == 'T') ||
                    (cs[j] == 'T' && cs[j + 1] == 'Y'))) {
                j += 2;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        System.out.println(maxLen);
    }
}

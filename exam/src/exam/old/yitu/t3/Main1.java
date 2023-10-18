package exam.old.yitu.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        char[] cs = s.toCharArray();
        int n = cs.length;
        int maxLen = 0;
        for(int i = 0; i < n ;i++){
            int j = i;
            while(i + 1 < n && (cs[i] == 'Y' && (cs[i + 1] == 'T') ||
                    (cs[i] == 'T' && cs[i + 1] == 'Y'))){
                i += 2;
            }
            maxLen = Math.max(maxLen, i - j);
        }
        System.out.println(maxLen);
    }
}

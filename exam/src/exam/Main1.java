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
        int n = cin.nextInt();
        System.out.printf("%d次\n", n);
        System.out.println("Copy All");
        for (int i = 1; i < n; i++) {
            System.out.println("Paste");
        }
    }
}
/**
 * 4
 * 3 7 9
 * 1 2 4
 * 1 11 12
 * 12345 98765 56789
 */
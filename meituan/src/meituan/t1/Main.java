package meituan.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m, n;
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            int[] da = new int[n];
            for (int i = 0; i < n; i++) {
                da[i] = cin.nextInt();
            }
            m = cin.nextInt();
            char[] opts = new char[n];
            for (int i = 0; i < n; i++) {
                opts[i] = '+';
            }
            //StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                // lo1-1,loc
                int loc = cin.nextInt();
                char opt = cin.next().charAt(0);
                double res = 0;
                if (opt == '*') {
                    int t = da[loc - 1] * da[loc];
                    for(int j = 0; j < n; j++){
                        if(j == loc - 1 || j == loc) continue;
                        res += da[j];
                    }
                    res += t;
                } else if (opt == '/') {
                    double t = (double) da[loc - 1] / da[loc];
                    for(int j = 0; j < n; j++){
                        if(j == loc - 1 || j == loc) continue;
                        res += da[j];
                    }
                    res += t;
                }else if (opt == '+') {
                    for(int j = 0; j < n; j++){
                        res += da[j];
                    }
                }else if (opt == '-') {
                    int t = da[loc - 1] - da[loc];
                    for(int j = 0; j < n; j++){
                        res += da[j];
                    }
                    res -= da[loc] * 2;
                }
                System.out.printf("%.1f",res);
                if(i != m -1){
                    System.out.printf(" ");
                }
            }
        }
    }
}

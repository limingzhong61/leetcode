package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

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
        //System.out.println(String.valueOf(Long.MAX_VALUE).length());
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        long[] l= new long[n+1];
        long[] r= new long[n+1];
        long[] x= new long[n+1];

        for(int i = 0; i < n; i++){
            l[i] = cin.nextLong();
            r[i] = cin.nextLong();
            x[i] = cin.nextLong();
        }

        for(int i = 0; i < m; i++){
            long p = cin.nextInt();
            long res = 0;
            for(int j = 0; j <= m; j++){
                if(l[j] <= p && p <= r[j]){
                    res ^=  x[j];
                }
            }
            System.out.println(res);
        }

    }
}
/**
 2 2
 1 5 1
 3 7 2
 4
 6
 */
package meituan.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n;
        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            int[] h = new int[n];
            for(int i = 0; i < n ;i++){
                h[i] = cin.nextInt();
            }
            Arrays.sort(h);
            long res  =0 ;
            for(int i = 1; i < n; i++){
                res += h[i] - h[i-1];
            }
            System.out.println(res);
        }
    }
}

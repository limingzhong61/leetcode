package meituan.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n, m;
        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            m = cin.nextInt();
            int[] arr = new int[n+1];
            int[] op = new int[m];
            int[] x = new int[m];
            int[] y = new int[m];
            for(int i = 0; i < m; i++){
                op[i] = cin.nextInt();
            }
            for(int i = 0; i < m; i++){
                x[i] = cin.nextInt();
            }
            for(int i = 0; i < m; i++){
                y[i] = cin.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            for(int i =  0; i < m; i++){
                if(op[i] == 0){
                    arr[x[i]] = y[i];
                }else{
                    long res = 0;
                    for(int j = x[i];  j <= y[i]; j++){
                        res += arr[j];
                    }
                    sb.append(res).append(' ');
                }
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}

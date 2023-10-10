package exam.old.duxiaomang.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        String target = "accept";
        for(int k = 0; k < t; k++){
            int n = cin.nextInt();
            int m = cin.nextInt();
            String[] cs  = new String[n];
            for(int i = 0; i < n; i++){
                cs[i] = cin.next();
            }
            String res = "NO";
            for(int i = 0; i < n; i++){
                if(cs[i].contains(target)){
                    res = "YES";
                    break;
                }
            }
            if(!"YES".equals(res)){
                for(int j = 0; j < m; j++){
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < n; i++){
                        sb.append(cs[i].charAt(j));
                    }
                    if(sb.toString().contains(target)){
                        res = "YES";
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}

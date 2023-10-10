package exam.old.duxiaomang.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for(int k = 0; k < t; k++){
            int n = cin.nextInt();
            int m = cin.nextInt();
            int[]a = new int[n+1];
            for(int i = 1; i <= n; i++){
                a[i] = cin.nextInt();
            }

            int ans = m + 1;
            boolean ordered = false;
            boolean judge = true;
            for(int j = 0; j < n; j++){
                if(a[j] > a[j+1]){
                    judge = false;
                    break;
                }
            }
            if(judge){
                ordered = true;
                ans = 0;
            }
            for(int i = 0; i < m; i++){

                int x = cin.nextInt();
                int y = cin.nextInt();
                if(ordered) continue;
                if(a[x] > a[y]){
                    int temp = a[x];
                    a[x] = a[y];
                    a[y] = temp;
                }else{
                    continue;
                }
                 judge = true;
                for(int j = 0; j < n; j++){
                    if(a[j] > a[j+1]){
                        judge = false;
                        break;
                    }
                }
                if(judge){
                    ordered = true;
                    ans = i + 1;
                }

            }
            System.out.println(ans);

        }

    }
}

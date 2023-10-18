package exam.old.gld.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        int val = a[n-1];
        int cnt = 0;
        for(int i = n-1; i >= 0; i--){
            int j = i;
            while(j >= 0 && a[j] == val){
                    j--;
            }
            int len = n - j - 1;
            i = n - 2 * len;
            cnt++;
        }
        System.out.println(cnt);
    }
}
/**

 4
 1 2 2 2

 4
 1 2 3 4


 */
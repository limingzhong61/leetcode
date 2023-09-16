package exam.old.didi.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = cin.nextInt();
        }
        int left = 0, right = n + 1;
        while(left < right){
            int mid = left + (right - left) / 2;

            int count = 0;
            int start = a[0];
            for(int i = 1; i < n; i++){
                if(a[i] - start >= mid){
                    count++;
                    start = a[i];
                }
            }
            if(count + 1 >= k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
}

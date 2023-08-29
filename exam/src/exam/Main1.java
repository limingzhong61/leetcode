package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.Arrays;
import java.util.Scanner;

/**
6
2 2 4 5 1 2

 3
 1 1 1

 2
 10 100
 */
public class Main1 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt(),k = cin.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = cin.nextInt() - k;
        }
        int ans = 0;
        int left = 0;
        long sum = 0;
        for(int right = 0; right < n; right++){
            sum += arr[right];
            if(sum > 0){

            }
        }
        for(int i = 0; i < n; i++){
            int start = 0;
            for(int j = i; j < n; j++){
                start += arr[j];
                if(start == 0){
                    ans = Math.max(j - i + 1, ans);
                }
            }
        }
        System.out.println(ans);
    }
}
/**
 5 2
 1 3 2 4 1

 5 2
 4 1 1 3 2
 */
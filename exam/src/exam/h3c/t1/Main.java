package exam.h3c.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            boolean prime = true;
            for(int j = 2; j*j <= i; j++){
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                ans.add(i);
            }
        }
        System.out.println(ans);
    }
}

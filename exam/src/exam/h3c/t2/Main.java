package exam.h3c.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] split1 = line.split("; ");
        String s = split1[0];
        long target = Long.parseLong(split1[1]);

        String[] split = s.split(", +");

        long[] a = new long[split.length];

        int n = split.length;

        for(int i = 0; i < n ; i++){
            a[i] = Long.parseLong(split[i]);
        }


        //int ansIdx1 = -1,ansIdx2 = -1;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(a[i] + a[j] == target){
                    //ansIdx1 = i;
                    //ansIdx1 = j;
                    System.out.printf("Indices: %d, %d", i, j);
                    return;
                }
            }
        }
        System.out.println("No two sum solution");
        //throw new RuntimeException("No two sum solution");
    }
}

package exam.mhy.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int h = in.nextInt();
        int[] t = new int[n];
        int[] x = new int[n];
        int sumT1 = 0, sumT2 = 0;
        int beforeT1 = 0;
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
            x[i] = in.nextInt();
            if (t[i] == 1) {
                beforeT1 += x[i];
            } else {
                sumT1 += beforeT1;
                beforeT1 = 0;
                sumT2 += x[i];
            }
        }
        h -= sumT2;
        if(sumT1 * 6 < h){
            System.out.println(0);
            return;
        }


        int low = h / sumT1;
        double totalPosCnt = Math.pow(6,sumT1);
        if (h % sumT1 == 0) {
            //double sucPosCnt = 1;
            double sucPosCnt = Math.pow((6 - low + 1),sumT1);
            System.out.println( sucPosCnt/ totalPosCnt);
            return;
        }


        int high = low + 1;
        int highCnt = h - (sumT1 * low);
        int lowCnt = sumT1 - highCnt;
        lowCnt++;
        highCnt--;
        double pickCnt = 1;
        for(int i = 0; i < lowCnt; i++){
            pickCnt *= low;
        }
        for(int i = 0; i < highCnt; i++){
            pickCnt *= high;
        }
        System.out.println(1 - (pickCnt / totalPosCnt));
    }
}
/**
 2 5
 1 1
 2 1


 2 5
 1 3
 2 1

 2 5
 1 2
 2 1
 */
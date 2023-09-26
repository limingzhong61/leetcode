package exam.old.xm.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String next = cin.next();
        String[] split = next.split(",");
        int n = Integer.parseInt(split[0]);
        int r = Integer.parseInt(split[1]);
        int[] x = new int[n];
        int[] y = new int[n];
        int[] q = new int[n];
        for(int i = 0; i < n; i++){
            next = cin.next();
            split = next.split(",");
            x[i] = Integer.parseInt(split[0]);
            y[i] = Integer.parseInt(split[1]);
            q[i] = Integer.parseInt(split[2]);
        }
        int max = 100;
        int minQ = Integer.MIN_VALUE;
        int ansX = -1,ansY = -1;
        for(int i = 0; i <= max; i++){
            for(int j = 0; j <= max; j++){
                int allQ = 0;
                for(int k = 0; k < n; k++){
                    int dx = i - x[k];
                    int dy = j - y[k];
                    if(dx * dx + dy * dy <= r * r){
                        allQ += (int)Math.floor(q[k] / (1.0 + Math.sqrt(dx * dx + dy * dy )));

                    }
                }
                if(allQ > minQ){
                    minQ = allQ;
                    ansX = i;
                    ansY = j;
                    //System.out.printf("%d,%d,%d\n",ansX,ansY,minQ);
                }
            }
        }
        System.out.printf("%d,%d",ansX,ansY);


    }
}

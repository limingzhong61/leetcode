package exam.old.webank.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    /**
     * 并查集
     */
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        // 1-n
        int n = cin.nextInt();
        int m = cin.nextInt();
        // s != t
        int s = cin.nextInt();
        int t = cin.nextInt();
        int[] f = new int[n+1];
        int[] w = new int[n+1];
        for(int i = 1; i <= n; i++){
            f[i] = i;
            w[i] = 1;
        }
        //稀疏图
        for(int i = 0; i < m; i++){
            int x = cin.nextInt();
            int y = cin.nextInt();

            // 合并, 归为 rX
            int rX = getRoot(f,x);
            int rY = getRoot(f,y);
            if(rX != rY){
                if(w[rX] > w[rY]){
                    w[rX] += w[rY];
                    f[rY] = rX;
                }else{
                    w[rY] += w[rX];
                    f[rX] = rY;
                }
            }
        }
        int rS = getRoot(f, s);
        int rT = getRoot(f, t);
        long ans = 0;


        //相连
        if(rS == rT){
            // long countS = 0;
            // for(int i = 1; i <= n; i++){
            //     if(rS == f[i]){
            //         countS++;
            //     }
            // }
            // ans = countS * (countS-1) / 2 + (n - countS) * countS;
            ans = (long) n * (n-1) / 2;
        }else{
            long countS = 0;
            for(int i = 1; i <= n; i++){
                if(rS == getRoot(f,i)){
                    countS++;
                }
            }
            long countT = 0;
            for(int i = 1; i <= n; i++){
                if(rT == getRoot(f,i)){
                    countT++;
                }
            }
            ans = countT * countS;
        }
        System.out.println(ans);
    }

    private static int getRoot(int[] f, int i) {
        int preI = i;
        while(i != f[i]){
            i = f[i];
        }

        f[preI] = i;
        return i;
    }
}



/**
3 2 1 3
1 2
2 3
 */
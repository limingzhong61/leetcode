package exam.old.webank.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            q.add(cin.nextInt());
        }

        while(!q.isEmpty()){
            int poll = q.poll();
            System.out.printf("%d ",poll);
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
    }
}

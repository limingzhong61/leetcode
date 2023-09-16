package exam.old.webank.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = cin.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n-1; i >= 0; i--){
            if(!set.contains(a[i])){
                list.add(a[i]);
                set.add(a[i]);
            }
        }
        for(int i = list.size() - 1; i >= 0; i--){
            System.out.printf("%d ",list.get(i));
        }

    }
}

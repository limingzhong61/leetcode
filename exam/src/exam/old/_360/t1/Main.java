package exam.old._360.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            ArrayList<Integer> list = map.getOrDefault(a[i], new ArrayList<>());
            list.add(i + 1);
            map.put(a[i],list);
        }

        System.out.println(map.size());
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> list = entry.getValue();
            ans.add(list.get(list.size()/ 2));
            
        }
        ans.sort(Integer::compare);
        for (Integer an : ans) {
            System.out.printf(an + " ");
        }
    }
}
/**
 9
 3 4 5 5 3 4 4 5 3
 4 5 6

 4
 5 5 5 5

 */
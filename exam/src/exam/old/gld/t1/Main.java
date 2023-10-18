package exam.old.gld.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }

        int[] e = new int[n];
        // end, max
        TreeMap<Integer,Integer> maxMap = new TreeMap<>();
        maxMap.put(s[0] + t[0], a[0]);
        int ans = a[0];
        for (int i = 1; i < n; i++) {
            Map.Entry<Integer, Integer> entry = maxMap.floorEntry(s[i]);
            int max = a[i];
            if(entry != null){
                //System.out.printf("%d,%d\n",s[i],entry.getKey());
                max += entry.getValue();
            }
            int endTime = s[i] + t[i];
            Map.Entry<Integer, Integer> floorEntry = maxMap.floorEntry(endTime);
            int endTimeMax = max;
            if(floorEntry != null){
                endTimeMax = Math.max(floorEntry.getValue(), endTimeMax);
            }
            maxMap.put(s[i]+t[i], endTimeMax);
            ans = Math.max(ans, max);

        }
        System.out.println(ans);
    }
}
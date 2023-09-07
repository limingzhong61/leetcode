package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            time[i][0] = cin.nextInt();
            time[i][1] = cin.nextInt();
        }
        Arrays.sort(time, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int ans = 0;
        for (int i = 0; i < n; i++) {
            //int start = time[i][0];
            int end = time[i][1];
            int cnt = 1;
            for (int j = i + 1; j < n; j++) {
                if (time[j][0] >= end) {
                    cnt++;
                    end = time[j][1];
                    //System.out.printf("[%d,%d], ", time[j][0], time[j][1]);
                }
            }
            ans = Math.max(ans, cnt);
            //System.out.println();
        }
        System.out.println(ans);
    }
}
/**
 * 11
 * 6 9
 * 10 14
 * 11 15
 * 5 11
 * 10 12
 * 13 16
 * 7 18
 * 17 19
 * 13 17
 * 8 10
 * 8 13
 */
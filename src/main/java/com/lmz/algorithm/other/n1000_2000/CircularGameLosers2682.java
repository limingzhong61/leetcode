package com.lmz.algorithm.other.n1000_2000;

import java.util.ArrayList;

/**
 * @author: limingzhong
 * @create: 2023-08-16 10:07
 */
public class CircularGameLosers2682 {
    public int[] circularGameLosers(int n, int k) {
        int[] arr = new int[n];
        int start = 0, cnt = 1;
        while (true) {
            arr[start]++;
            if (arr[start] >= 2) break;
            start = (start + cnt * k) % n;
            // System.out.println(start);
            cnt++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                list.add(i+1);
        }
        int[] ans = ArrayListToIntArray(list);
        return ans;
    }

    private static int[] ArrayListToIntArray(ArrayList<Integer> list) {
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

package exam;//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 6
 * 2 2 4 5 1 2
 * <p>
 * 3
 * 1 1 1
 * <p>
 * 2
 * 10 100
 */
public class Main2 {
    public static int ans(int[] values, int h) {
        int max = 0;
        for (int x : values) {
            max = Math.max(max, x);
        }
        int left = 0, right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 0;
            for (int x : values) {
                need += x / mid;
                if (x % mid != 0) need++;
            }
            if (need > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder();
        System.out.println(Math.round(0.99));
        System.out.println((int) 0.09);
        System.out.println(ans(new int[]{3,6,7,11},8));
    }
}
/**
 * 1101010110010110
 * 8
 * 110
 * 2
 * 110000
 */
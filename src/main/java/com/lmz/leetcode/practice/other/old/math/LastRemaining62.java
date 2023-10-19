package com.lmz.leetcode.practice.other.old.math;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining62 {
    /**
     * dp递推，如n = 2,删除那个index；
     */
    public int lastRemaining(int n, int m) {
        int x = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    /**
     * 数学 + 递归 ，
     */
    public int lastRemaining2(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    /**
     * 模拟删除
     */
    public int lastRemaining1(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            //因为起点本身算1，故只需要移动m-1次
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        LastRemaining62 lastRemaining62 = new LastRemaining62();

        System.out.println(lastRemaining62.lastRemaining(5, 3));
        System.out.println(lastRemaining62.lastRemaining(5, 3) == 3);

        System.out.println(lastRemaining62.lastRemaining(10, 17));
        System.out.println(lastRemaining62.lastRemaining(10, 17) == 2);

        System.out.println(lastRemaining62.lastRemaining(70866, 116922));
        System.out.println(lastRemaining62.lastRemaining(70866, 116922) == 2);
    }
}

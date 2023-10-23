package com.lmz.leetcode.practice.p.medium;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-06-07 10:22
 */
public class MiceAndCheese2611 {
    /**
     * 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
     *
     * 把奶酪全部给第二只老鼠，然后「撤销」其中的一块奶酪i，给第一只老鼠。
     * 这次操作使得整体的值，变化为reward1[i]-reward2[i];
     *
     */
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0,n = reward1.length;
        for(int i = 0; i < n; i++){
            ans += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        for(int i = n - k; i < n; i++){
            ans += reward1[i];
        }
        return ans;
    }
}

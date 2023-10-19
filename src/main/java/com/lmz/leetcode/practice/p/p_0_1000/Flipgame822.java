package com.lmz.leetcode.practice.p.p_0_1000;

import java.util.HashSet;

/**
 * @author: limingzhong
 * @create: 2023-08-02 10:13
 */
public class Flipgame822 {
    /**
     * 如果某个数出现在某张牌的正反两面，那么它一定没资格成为答案
     * 反之，如果某个数从未同时出现在任意一张牌的正反两面，那么他一定有资格成为答案
     * 从所有有资格的牌里挑一张最顺眼的就行
     *
     *
     * 根据题意，只要有数字满足 fronts[i]=backs[i]，
     * 那么 fronts[i]绝对不可能是答案，否则 fronts[i]或者 backs[i]作为背面的数字可以满足要求，取最小值作为答案。
     * 我们可以先遍历一遍数组，找到满足 fronts[i]=backs[i] 的数字，存入哈希表 forbidden中。
     * 然后再次遍历数组，找到不在 forbidden中的数字，取最小值作为答案。如果所有数字都在 forbidden中，返回 0。
     */
    public int flipgame(int[] fronts, int[] backs) {
        var forbidden = new HashSet<Integer>();
        for (int i = 0; i < fronts.length; i++)
            if (fronts[i] == backs[i])
                forbidden.add(fronts[i]);

        int ans = Integer.MAX_VALUE;
        for (int x : fronts) if (!forbidden.contains(x)) ans = Math.min(ans, x);
        for (int x : backs) if (!forbidden.contains(x)) ans = Math.min(ans, x);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

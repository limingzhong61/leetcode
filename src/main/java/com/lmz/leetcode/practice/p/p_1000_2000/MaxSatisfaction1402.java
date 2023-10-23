package com.lmz.leetcode.practice.p.p_1000_2000;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-10-23 10:56
 */
public class MaxSatisfaction1402 {
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            int f = 0; // f(0) = 0
            int s = 0;
            for (int i = satisfaction.length - 1; i >= 0; i--) {
                s += satisfaction[i];
                if (s <= 0) { // 后面不可能找到更大的 f(k)
                    break;
                }
                f += s; // f(k) = f(k-1) + s
            }
            return f;
        }
    }

// 作者：灵茶山艾府
// 链接：https://leetcode.cn/problems/reducing-dishes/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

package codeofli.leetcode.other.easy.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxEqualFreq1224 {
    /**
     * leetcode:模拟（计数 + 分情况讨论）
     * cnt 数组记录每个数的出现次数
     * 使用 sum 来记录出现次数为某个值的数有多少个
     * 注意：求的是最长前缀
     * 而且必须从前缀中删除一个元素
     */
    public int maxEqualFreq(int[] nums) {
        //1 <= nums[i] <= 105
        int N = 100001;
        int[] cnt = new int[N];
        int[] sum = new int[N];
        int n = nums.length, max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i], cur = ++cnt[t], len = i + 1;
            sum[cur]++;
            sum[cur - 1]--;
            max = Math.max(max, cur);
            if (max == 1) res = len;
            if (max * sum[max] + 1 == len) res = len;
            if ((max - 1) * (sum[max - 1] + 1) + 1 == len) res = len;
        }
        return res;
    }

}

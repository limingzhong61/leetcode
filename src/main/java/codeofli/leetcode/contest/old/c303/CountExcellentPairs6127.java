package codeofli.leetcode.contest.old.c303;

import codeofli.my.leetcode.TransformUtil;

import java.util.HashSet;
import java.util.Set;

public class CountExcellentPairs6127 {
    /**
     * 脑筋急转弯
     * 第i位在两个数里出现几次，它的贡献就是几。
     */
    public long countExcellentPairs(int[] nums, int k) {
        //1 <= nums.length <= 105
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxP = 31;
        int[] cnt = new int[maxP + 1];
        for (int num : set) {
            int t = 0;
            for (int i = 0; i <= maxP; i++) {
                t += (num >> i) & 1;
            }
            cnt[t]++;
        }
        long res = 0;
        for (int i = 0; i <= maxP; i++) {
            for (int j = 0; j <= maxP; j++) {
                if (i + j >= k) {
                    res += (long) cnt[i] * cnt[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountExcellentPairs6127 countExcellentPairs6127 = new CountExcellentPairs6127();
        System.out.println(countExcellentPairs6127.countExcellentPairs(TransformUtil.toIntArray("[1,2,3,1]"), 3));
        System.out.println(countExcellentPairs6127.countExcellentPairs(TransformUtil.toIntArray("[1,2,3,1]"), 3) == 5);
        System.out.println(countExcellentPairs6127.countExcellentPairs(TransformUtil.toIntArray("[5,1,1]"), 10));
        System.out.println(countExcellentPairs6127.countExcellentPairs(TransformUtil.toIntArray("[5,1,1]"), 10) == 0);
    }
}

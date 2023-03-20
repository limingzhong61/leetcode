package lmz.leetcode.bruce_solution.bruce_search.my.solution_template.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合操作
 * @author: limingzhong
 * @create: 2022-10-22 10:37
 */
public class SetOperation {
    /**
     * 集合交集操作：
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
     * @param nums1
     * @param nums2
     * @return 输出结果中的每个元素一定是 唯一的。返回值不考虑输出结果的顺序 。
     * example：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }
        Set<Integer> inter = new HashSet<>();
        for (int x : nums2) {
            if (set.contains(x)) {
                inter.add(x);
            }
        }
        int[] res = new int[inter.size()];
        int idx = 0;
        for(int x : inter){
            res[idx++] = x;
        }
        return res;
    }
}

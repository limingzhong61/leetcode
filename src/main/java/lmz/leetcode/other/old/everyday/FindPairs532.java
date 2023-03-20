package lmz.leetcode.other.old.everyday;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairs532 {
    /**
     * leetcode: Set
     * 遍历数组时，可以将遍历到的下标当作潜在的 j，判断 j 左侧是否有满足条件的 i 来构成 k-diff 数对，
     * 而这一判断也可以通过提前将下标 j 左侧的元素都放入另一个哈希表 visited 来降低时间复杂度。
     */
    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    /**
     * 排序后，用双指针统计；
     */
    public int findPairs1(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0, len = nums.length;
        int left = 0, right = 1;
        //-107 <= nums[i] <= 107
        int lastLeft = Integer.MAX_VALUE, lastRight = Integer.MAX_VALUE;
        while (left <= right && right < len) {
            int diff = nums[right] - nums[left];
            if (left != right && diff == k) {
                //相同数对值，需要跳过
                if (lastLeft == nums[left] && lastRight == nums[right]) {
                    right++;
                    continue;
                }
                cnt++;
                //记录上一次成功的数对值
                lastLeft = nums[left];
                lastRight = nums[right];
                right++;
                //    小于等于时，right先走(特别是diff=0的时候)
            } else if (diff <= k) {
                right++;
            } else {
                left++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        FindPairs532 findPairs532 = new FindPairs532();
        //
        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[3, 1, 4, 1, 5]"), 2));
        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[3, 1, 4, 1, 5]"), 2) == 2);

        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1, 2, 3, 4, 5]"), 1));
        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1, 2, 3, 4, 5]"), 1) == 4);

        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1, 3, 1, 5, 4]"), 0));
        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1, 3, 1, 5, 4]"), 0) == 1);

        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1,2,3,4,5]"), 0));
        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1,2,3,4,5]"), 0) == 0);

        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1,1,1,2,2]"), 0));
        System.out.println(findPairs532.findPairs(TransformUtil.toIntArray("[1,1,1,2,2]"), 0) == 2);
    }
}

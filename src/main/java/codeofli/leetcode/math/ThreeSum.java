package codeofli.leetcode.math;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.*;

public class ThreeSum {
    /**
     * leetcode:双指针
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        // 枚举 a
        for (int a = 0; a < nums.length; a++) {
            // 需要和上一次枚举的数不相同
            if (a > 0 && nums[a - 1] == nums[a]) { // find next diff value
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int c = n - 1;
            int target = -nums[a];
            // 枚举 b
            for (int b = a + 1; b < nums.length; b++) {
                // 需要和上一次枚举的数不相同
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (c > b && nums[b]+nums[c] > target) {
                    c--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (b == c){
                    break;
                }
                if (nums[a]+nums[b]+nums[c] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[a]);
                    temp.add(nums[b]);
                    temp.add(nums[c]);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> aSet = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-nums[i] - nums[j])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(-nums[i] - nums[j]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    if (!aSet.contains(temp)) {
                        aSet.add(temp);
                        res.add(temp);
                    }
                }

            }
            set.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(StringTransformUtil.toIntArray("[0,0,0,0]")));
        System.out.println(threeSum.threeSum(StringTransformUtil.toIntArray("[0,0,0,0]")).equals(StringTransformUtil.toDoubleArrayList("[[0, 0, 0]]")));
        System.out.println(threeSum.threeSum(StringTransformUtil.toIntArray("[-1,0,1,2,-1,-4]")));
        System.out.println(threeSum.threeSum(StringTransformUtil.toIntArray("[-1,0,1,2,-1,-4]")).equals(StringTransformUtil.toDoubleArrayList("[[-1, -1, 2], [-1, 0, 1]]")));
    }
}

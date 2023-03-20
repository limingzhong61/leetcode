package lmz.leetcode.two_points;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.*;

public class ThreeSumII007 {
    /**
     * my: 双指针:
     * 三个数：a,b,c,且，a<b<c
     * 固定a,左右扫描指针b，c
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a - 1] == nums[a]) { // find next diff value
                continue;
            }
            int target = -nums[a];
            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                int sum = nums[b]  + nums[c];
                if (sum <= target) {
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[c]);
                        res.add(temp);
                    }
                    // 找到相同大小的最后一个数字
                    while (b+1 < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    b++;
                } else {
                    // 找到相同大小的最后一个数字
                    while (b < c - 1 && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    c--;
                }
            }
        }
        return res;
    }

    private int getNextDiffIdx(int[] nums, int a, int bound) {

        return a;
    }

    /**
     * leetcode:双指针
     */
    public List<List<Integer>> threeSum1(int[] nums) {
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
                while (c > b && nums[b] + nums[c] > target) {
                    c--;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (b == c) {
                    break;
                }
                if (nums[a] + nums[b] + nums[c] == 0) {
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
        ThreeSumII007 threeSum = new ThreeSumII007();
        //testCase(threeSum, "[0,0,0,0]", "[[0, 0, 0]]");
        //testCase(threeSum, "[-1,0,1,2,-1,-4]", "[[-1, -1, 2], [-1, 0, 1]]");
        testCase(threeSum, "[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]", "[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]");
    }

    private static void testCase(ThreeSumII007 threeSum, String original, String original1) {
        System.out.println(threeSum.threeSum(TransformUtil.toIntArray(original)));
        System.out.println(threeSum.threeSum(TransformUtil.toIntArray(original)).
                equals(TransformUtil.toDoubleArrayList(original1)));
    }
}

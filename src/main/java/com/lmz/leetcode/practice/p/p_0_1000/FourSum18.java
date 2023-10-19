package com.lmz.leetcode.practice.p.p_0_1000;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-07-15 11:59
 */
public class FourSum18 {
    /**
     * 固定 a,b 双指针枚举 c,d
     * 如何去重： 下一个a与前一个a同，则后序的序列任然会存在相同，则只需要保证下一个a与前一个a不同 如 存在 a1,b1,c1,d1，则a2，b1,c1,d1 当a1=a2时，这两个是同一个序列
     *  b,c 同理，d不用管
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;      //确保nums[a] 改变了
            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;   //确保nums[b] 改变了
                // 双指针
                long need = (long) target - nums[a] - nums[b];
                int c = b + 1, d = n - 1;
                while (c < d) {
                    if (nums[a] + nums[b] - target < -(nums[c] + nums[d]))//原写法num[a]+num[b]+num[c]+num[d]<target为了防止溢出，见下面的补充修改
                        c++;

                    if (nums[c] + nums[d] == need) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        ans.add(list);

                    }
                    if (nums[c] + nums[d] > need) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum18 fourSum18 = new FourSum18();
        testCase(fourSum18, "[1000000000,1000000000,1000000000,1000000000]", -294967296, "[]");
        testCase(fourSum18, "[1,0,-1,0,-2,2]", 0, "[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]");

        testCase(fourSum18, "[2,2,2,2,2]", 8, "[[2,2,2,2]]");
    }

    private static void testCase(FourSum18 fourSum18, String original, int target, String original1) {
        System.out.println(fourSum18.fourSum(TransformUtil.toIntArray(original), target));
        System.out.println(fourSum18.fourSum(TransformUtil.toIntArray(original), target).equals(TransformUtil.toDoubleArrayList(original1)));
    }
}

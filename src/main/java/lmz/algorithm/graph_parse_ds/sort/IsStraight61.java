package lmz.algorithm.graph_parse_ds.sort;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class IsStraight61 {
    /**
     * leetcode:集合 Set + 遍历，遍历五张牌，遇到大小王（即 0 ）直接跳过
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int zeroCnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else if (i < n - 1) {
                //有两张相同的
                if (nums[i] == nums[i + 1]) {
                    return false;
                } else if (nums[i] + 1 != nums[i + 1]) {
                    // (n,n+x),只需要补x-1个
                    zeroCnt -= nums[i + 1] - nums[i] - 1;
                    if (zeroCnt < 0) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        IsStraight61 isStraight61 = new IsStraight61();

        System.out.println(isStraight61.isStraight(TransformUtil.toIntArray("[1,2,3,4,5]")));
        System.out.println(String.valueOf(
                isStraight61.isStraight(TransformUtil.toIntArray("[1,2,3,4,5]")
                ) == true).toUpperCase(Locale.ROOT));

        System.out.println(isStraight61.isStraight(TransformUtil.toIntArray("[0,0,1,2,5]")));
        System.out.println(String.valueOf(
                isStraight61.isStraight(TransformUtil.toIntArray("[0,0,1,2,5]")
                ) == true).toUpperCase(Locale.ROOT));

        System.out.println(isStraight61.isStraight(TransformUtil.toIntArray("[0,0,2,2,5]")));
        System.out.println(String.valueOf(
                isStraight61.isStraight(TransformUtil.toIntArray("[0,0,2,2,5]")
                ) == false).toUpperCase(Locale.ROOT));
    }
}

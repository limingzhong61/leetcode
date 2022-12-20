package lmz.leetcode.bruce_solution.bruce_search;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CanPartitionKSubsets698 {
    /**
     * 如果当前桶的值和前一个桶相等，直接看下一个桶;剪枝优化
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = IntStream.of(nums).sum();
        int target = sum / k;
        if (target * k != sum) {  //不能k等分
            return false;
        }
        for (int x : nums) {
            if (x > target) {
                return false;
            }
        }
        Arrays.sort(nums);
        int[] targets = new int[k];
        Arrays.fill(targets, target);
        return search(nums, targets, nums.length - 1);
    }

    int startIdx = 0;

    private boolean search(int[] nums, int[] targets, int cur) {
        if (cur < 0) {
            for (int x : targets) {
                if (x != 0) {
                    return false;
                }
            }
            return true;
        }
        for (int i = startIdx; i < targets.length; i++) {
            //如果当前桶的值和前一个桶相等，直接看下一个桶;剪枝优化
            if (targets[i] - nums[cur] < 0 || i > 0 && targets[i] == targets[i - 1]) {
                continue;
            }
            targets[i] -= nums[cur];
            if (search(nums, targets, cur - 1)) {
                return true;
            }
            targets[i] += nums[cur]; //回溯
        }
        return false;
    }


    public static void main(String[] args) {
        CanPartitionKSubsets698 canPartitionKSubsets698 = new CanPartitionKSubsets698();
        //System.out.println(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.toIntArray("[10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8]"), 11));
        System.out.println(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.toIntArray("[3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269]\n"), 5));
        System.out.println(String.valueOf(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.
                toIntArray("[3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269]\n"), 5) == true).toUpperCase());
        System.out.println(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.toIntArray("[3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269]\n"), 5));
        System.out.println(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.toIntArray("[4,3,2,3,5,2,1]"), 4));
        System.out.println(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.toIntArray("[3,3,10,2,6,5,10,6,8,3,2,1,6,10,7,2]"), 6));
        System.out.println(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.toIntArray("[960,3787,1951,5450,4813,752,1397,801,1990,1095,3643,8133,893,5306,8341,5246]\n"), 6));
        System.out.println(canPartitionKSubsets698.canPartitionKSubsets(TransformUtil.toIntArray("[1,2,3,4]"), 3));
    }
}

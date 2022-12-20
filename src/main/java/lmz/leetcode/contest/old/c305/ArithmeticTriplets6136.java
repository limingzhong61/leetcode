package lmz.leetcode.contest.old.c305;

public class ArithmeticTriplets6136 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (diff == nums[j] - nums[i]) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[k] - nums[j] == diff) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}

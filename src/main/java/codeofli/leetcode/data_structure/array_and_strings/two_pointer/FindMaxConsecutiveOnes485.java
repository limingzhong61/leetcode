package codeofli.leetcode.data_structure.array_and_strings.two_pointer;

public class FindMaxConsecutiveOnes485 {
    /**
     * my
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                maxLength = Math.max(maxLength, cnt);
                cnt = 0;
            }
        }
        maxLength = Math.max(maxLength, cnt);
        return maxLength;
    }
}

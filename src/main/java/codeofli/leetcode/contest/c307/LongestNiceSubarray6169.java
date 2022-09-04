package codeofli.leetcode.contest.c307;

public class LongestNiceSubarray6169 {
    /**
     * 双指针
     */
    public int longestNiceSubarray(int[] nums) {
        //[left,right]
        int left = 0, right = 0;
        //1 <= nums.length <= 105
        int n = nums.length;
        int maxLen = 1;
        while (right < n) {
            int next = right + 1;
            boolean flag = true;
            for (int i = left; i <= right; i++) {
                if ((next & nums[i]) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                right = next;
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                left++;
                if (left > right) {
                    right = left;
                }
            }
            System.out.println(left);
            System.out.println(right);
            System.out.println();
        }
        return maxLen;
    }
}

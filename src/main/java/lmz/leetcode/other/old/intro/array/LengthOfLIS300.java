package lmz.leetcode.other.old.intro.array;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;

public class LengthOfLIS300 {
    /**
     * leetcode:手写二分查找
     */
    public int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
    /**
     * leetcode: 贪心+二分查找
     * 维护一个**数组 d[i] ，表示长度为 i 的最长上升子序列的末尾元素的最小值**，
     * **用 $\textit{len}$ 记录目前最长上升子序列的长度**，起始时 len 为 1，$d[1] = nums[0]$。
     */
    public int lengthOfLIS2(int[] nums) {
        //1 <= nums.length <= 2500
        int n = nums.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (d[len] < nums[i]) {
                d[++len] = nums[i];
            } else {
                int insertPos = Arrays.binarySearch(d,1,len, nums[i]);
                // > 0 说明有相同值，不用更新。
                if (insertPos < 0) {
                    d[-insertPos - 1] = nums[i];
                }
            }
        }
        return len;
    }

    /**
     * dp:
     * f[i]是[0,i]中以i结尾的最长递增子序列
     */
    public int lengthOfLIS1(int[] nums) {
        //1 <= nums.length <= 2500
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, f[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLIS300 lengthOfLIS300 = new LengthOfLIS300();
        System.out.println(lengthOfLIS300.lengthOfLIS(TransformUtil.toIntArray("[0,1,0,3,2,3]")));
        System.out.println(lengthOfLIS300.lengthOfLIS(TransformUtil.toIntArray("[0,1,0,3,2,3]")) == 4);
    }
}

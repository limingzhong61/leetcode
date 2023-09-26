package exam.old.xmly.t1;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        int ans = Math.max(0,Math.abs(nums[0]));
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1] + nums[i], nums[i]);
            min[i] = Math.min(min[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, Math.max(Math.abs(min[i]), max[i]));
        }
        return ans;
    }
}

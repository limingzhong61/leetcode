package exam.old.tc.t1;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 通过所有乐趣值，计算最优（乐趣值和最大）的旅行线路，获得最高的乐趣值。
     * @param nums int整型一维数组 所有的城市乐趣值
     * @return int整型
     */
    public int travel (int[] nums) {
        // write code here
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0],nums[1]);
        int ans = f[1];
        for(int i = 2; i < n; i++){
            f[i] = Math.max(f[i-1],f[i-2] + nums[i]);
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}

package lmz.leetcode.other.easy.old;

public class ProductExceptSelf238 {
    /**
     * 用前缀和的思想，构建前缀乘积
     * f[i]表示[0，i-1]的乘积，f[0] =1;
     * f2[i]表示[i+1, n-1]的乘积，f[n-1] = 1;
     * f[i]*f2[i] = [0，i-1]和 [i+1, n-1]的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        //2 <= nums.length <= 10^5,且保证计算不会越界
        int n = nums.length;
        int[] f = new int[n];
        int[] f2 = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * nums[i - 1];
        }
        f2[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            f2[i] = f2[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            f[i] *= f2[i];
        }
        return  f;
    }
}

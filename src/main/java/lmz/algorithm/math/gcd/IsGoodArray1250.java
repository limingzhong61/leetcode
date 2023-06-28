package lmz.algorithm.math.gcd;

public class IsGoodArray1250 {
    /**
     * 数论:
     * @param nums
     * @return
     */
    public boolean isGoodArray(int[] nums) {
        int x = nums[0];
        int n = nums.length;
        for(int i = 1; i  < n; i++){
            x = gcd(x,nums[i]);
        }
        return  x == 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

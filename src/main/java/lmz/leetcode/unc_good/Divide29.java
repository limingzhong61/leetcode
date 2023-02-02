package lmz.leetcode.unc_good;

/**
 * @author: limingzhong
 * @create: 2023-01-03 11:37
 */
public class Divide29 {
    /**
     * lc: 二分查找＋快速乘
     * 题目要求只能使用int32位，统一为负数。
     */
    public int divide(int dividend, int divisor) {
        // 特殊处理
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int low = 1,high = Integer.MAX_VALUE, ans = 0;
        while(low <= high){
            int mid = (high -low) / 2 + low;
            if(quickAdd(divisor,mid,dividend)){
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return rev ?  -ans : ans;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {     //奇数， 等价于 z % 2 ！= 0
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }


    public static void main(String[] args) {
        Divide29 divide29 = new Divide29();
        System.out.println(divide29.divide(10, 3));
        System.out.println(divide29.divide(10, 3) == 3);
    }
}

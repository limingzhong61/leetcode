package com.lmz.leetcode.practice.other.old.math;

/**
 * 剑指offer43
 */
public class CountDigitOne43 {
    public int countDigitOne1(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        int res = 0;
        long mulk = 1;
        for (int k = 0; n >= mulk; k++) {
            res += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return  res;
    }

    /**
     * 每次统计： 每一位上1的个数
     */
    public int countDigitOne2(int n) {
        // digit 表示 相应的位数 1,10,100,1000...
        long digit = 1, res = 0;
        // 设 n = 31024
        long high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return (int) res;
    }

    public int countDigitOne(int n) {
        // 从个位开始统计,base 表示对应位数 1,10,100,1000...
        long base = 1,high = 0,low = 0,ans = 0;
        while(n != 0){  //当 n 为 0 时，说明已经统计完毕，因此跳出
            high = n / 10;  //  将本轮 n 最低位删除，得到下轮 high
            long digit = n % 10; // 当前位的数   ，是本轮 n 的最低位
            if(digit == 0) ans += high * base;  //  当前位为0，当前位出现1，则高位可能为0~high-1；共high个
            else if(digit == 1) ans += high * base + low + 1;   //  当前位为1，当前位出现1，则高位可能为0~high-1；,加上 0~low共low+1个
            else ans += (high + 1) * base;  //  当前位 >= 1，当前位出现1，则高位可能为0~high-1；,加上 0~9共10个,故为high+1
            low += digit * base;    // 将 digit 加入 low ，组成下轮 low
            base *= 10;              // 位因子每轮 × 10
            n /= 10;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        CountDigitOne43 countDigitOne43 = new CountDigitOne43();

        testCase(countDigitOne43, 12, 5);

        testCase(countDigitOne43, 13, 6);

    }

    private static void testCase(CountDigitOne43 countDigitOne43, int n, int x) {
        System.out.println(countDigitOne43.countDigitOne(n));
        System.out.println(countDigitOne43.countDigitOne(n) == x);
    }
}

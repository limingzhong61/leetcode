package com.lmz.algorithm.other.old.math;

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
    public int countDigitOne(int n) {
        // digit 表示 相应的位数 1,10,100,1000...
        long digit = 1, res = 0;
        // 设 n = 31024
        long high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) { //当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
            if(cur == 0) res += high * digit;   //  当前位为0，当前位出现1，则高位可能为0~high-1；共high个
            else if(cur == 1) res += high * digit + low + 1; //  当前位为1，当前位出现1，则高位可能为0~high-1；,加上 0~low共low+1个
            else res += (high + 1) * digit; //  当前位>= 1，当前位出现1，则高位可能为0~high-1；,加上 0~9共10个
            low += cur * digit;     // 将 cur 加入 low ，组成下轮 low
            cur = high % 10;        //下轮 cur 是本轮 high 的最低位
            high /= 10;             //  将本轮 high 最低位删除，得到下轮 high
            digit *= 10;            // 位因子每轮 × 10
        }
        return (int) res;
    }

    public static void main(String[] args) {
        CountDigitOne43 countDigitOne43 = new CountDigitOne43();

        System.out.println(countDigitOne43.countDigitOne(12));
        System.out.println(countDigitOne43.countDigitOne(12) == 5);

        System.out.println(countDigitOne43.countDigitOne(13));
        System.out.println(countDigitOne43.countDigitOne(13) == 6);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(countDigitOne43.countDigitOne(Integer.MAX_VALUE));
        System.out.println(countDigitOne43.countDigitOne(Integer.MAX_VALUE) == 6);

    }
}

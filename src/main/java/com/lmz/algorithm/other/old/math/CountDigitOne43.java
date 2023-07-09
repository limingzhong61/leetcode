package com.lmz.algorithm.other.old.math;

public class CountDigitOne43 {
    public int countDigitOne(int n) {
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

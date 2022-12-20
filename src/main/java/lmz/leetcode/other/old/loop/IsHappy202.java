package lmz.leetcode.other.old.loop;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class IsHappy202 {
    /**
     * hashset 记录是否有重复
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            //System.out.println(n);
            n = digit(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public static int digit(int num) {
        int res = 0;
        while (num != 0) {
            int x = num % 10;
            res += x * x;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        IsHappy202 isHappy202 = new IsHappy202();

        testCase(isHappy202, 19, true);
        testCase(isHappy202, 2, false);
        testCase(isHappy202, 3, false);

    }

    private static void testCase(IsHappy202 isHappy202, int i, boolean b) {
        System.out.println(isHappy202.isHappy(i));
        System.out.println(String.valueOf(isHappy202.isHappy(i) == b).toUpperCase(Locale.ROOT));
    }
}

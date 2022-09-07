package codeofli.leetcode.other.easy;

import java.util.HashSet;
import java.util.Set;

public class LemonadeChange860 {
    public boolean lemonadeChange(int[] bills) {
        Set<Integer> set = new HashSet<>();
        for (int bill : bills) {
            if (bill == 5) {
                if (set.isEmpty()) {
                    set.add(5);
                } else {
                    for (int x : set) {
                        set.add(x + 5);
                    }
                }
            } else {
                int needReturn = bill - 5;
                if (set.isEmpty()) {
                    return false;
                }
                Set<Integer> temp = new HashSet<>();
                for (int x : set) {
                    if (x > needReturn) {
                        set.add(x - needReturn);
                    } else {
                        set.add(x);
                    }
                }
                set = temp;
            }
        }
        return true;
    }
}

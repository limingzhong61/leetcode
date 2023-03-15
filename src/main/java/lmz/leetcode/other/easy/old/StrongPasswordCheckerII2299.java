package lmz.leetcode.other.easy.old;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-01-19 11:16
 */
public class StrongPasswordCheckerII2299 {
    public boolean strongPasswordCheckerII(String password) {
        //它有至少 8 个字符。
        if (password.length() < 8) {
            return false;
        }
        //至少包含 一个小写英文 字母。
        //至少包含 一个大写英文 字母。
        //至少包含 一个数字 。
        //至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
        //它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
        Set<Character> set = new HashSet<>();
        String specialString = "!@#$%^&*()-+";
        for (char c : specialString.toCharArray()) {
            set.add(c);
        }
        boolean lowCase = false, upCase = false, digit = false, special = false;
        char[] cs = password.toCharArray();
        int len = cs.length;
        //char lastChar = cs[0];
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(cs[i])) {
                digit = true;
            } else if (Character.isUpperCase(cs[i])) {
                upCase = true;
            } else if (Character.isLowerCase(cs[i])) {
                lowCase = true;
            } else if (set.contains(cs[i])) {
                special = true;
            }
            if (i > 0 && cs[i] == cs[i - 1]) {
                return false;
            }
        }
        return digit && upCase && lowCase && special;
    }
}

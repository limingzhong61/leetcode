package codeofli.leetcode.other.old.primary.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class RomanToInt13 {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * leetcode: 所有两个字符的罗马数字组合都是前者比后者小（正常顺序都是前者数字比后者大）
     * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
     */
    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = symbolValues.get(s.charAt(i));
            if(i+1 < n && value < symbolValues.get(s.charAt(i+1)) ){
                ans -= value;
            }else {
                ans += value;
            }
        }
        return  ans;
    }


    /**
     * my
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    public int romanToInt1(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        //romanMap.put('I',1);
        //romanMap.put('X',10);
        //romanMap.put('C',100);
        romanMap.put('V', 5);
        romanMap.put('L', 50);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('I' == s.charAt(i)) {
                if (i + 1 < s.length()) {
                    if ('V' == s.charAt(i + 1)) {// 'IV'
                        ans += 4;
                        i++;
                        continue;
                    } else if ('X' == s.charAt(i + 1)) {// 'IX'
                        ans += 9;
                        i++;
                        continue;
                    }
                }
                ans += 1;
            } else if ('X' == s.charAt(i)) {
                if (i + 1 < s.length()) {
                    if ('L' == s.charAt(i + 1)) {// 'XL'
                        ans += 40;
                        i++;
                        continue;
                    } else if ('C' == s.charAt(i + 1)) {// 'XC'
                        ans += 90;
                        i++;
                        continue;
                    }
                }
                ans += 10;

            } else if ('C' == s.charAt(i)) {
                if (i + 1 < s.length()) {
                    if ('D' == s.charAt(i + 1)) {// 'CD'
                        ans += 400;
                        i++;
                        continue;
                    } else if ('M' == s.charAt(i + 1)) {// 'CM'
                        ans += 900;
                        i++;
                        continue;
                    }
                }
                ans += 100;
            } else {
                ans += romanMap.get(s.charAt(i));
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        RomanToInt13 romanToInt13 = new RomanToInt13();
        System.out.println(romanToInt13.romanToInt("III"));
        System.out.println(romanToInt13.romanToInt("IV"));
        System.out.println(romanToInt13.romanToInt("IX"));
        System.out.println(romanToInt13.romanToInt("LVIII"));
        System.out.println(romanToInt13.romanToInt("MCMXCIV"));

    }
}

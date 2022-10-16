package codeofli.leetcode.contest.c_1015;

public class CountTime {
    public int countTime(String time) {
        String[] split = time.split(":");
        String s = split[0],s2 = split[1];
        int f = 1,f2 = 1;
        if (s.charAt(0) == '?') {
            if (s.charAt(1) == '?') {
                f = 24;
            } else { // 只有第一位
                if (s.charAt(1) <= '0' + 3) {
                    f = 3;
                } else {
                    f = 2;
                }
            }
        } else {
            if (s.charAt(1) == '?') {
                if (s.charAt(0) <= '0' + 1) {
                    f = 10;
                } else {
                    f = 4;
                }
            }

        }
        if (s2.charAt(0) == '?') {
            if (s2.charAt(1) == '?') {
                f2 = 60;
            } else { // 只有第一位
                f2 = 6;
            }
        } else {
            if (s2.charAt(1) == '?') { // 只有第2位
                f2 = 10;
            }
        }
        return f * f2;
    }
}

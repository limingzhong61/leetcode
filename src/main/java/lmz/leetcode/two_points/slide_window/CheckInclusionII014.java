package lmz.leetcode.two_points.slide_window;

/**
 * @author: limingzhong
 * @create: 2023-01-06 15:43
 */
public class CheckInclusionII014 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] counter = new int[26];
        for (char c : s1.toCharArray()) {
            counter[c - 'a']--;
        }
        int len = s1.length();
        char[] cs2 = s2.toCharArray();
        for (int i = 0; i < len; i++) {
            counter[cs2[i] - 'a']++;
        }
        if (check(counter)) {
            return true;
        }
        for (int i = len; i < s2.length(); i++) {
            counter[cs2[i - len] - 'a']--;
            counter[cs2[i] - 'a']++;
            if (check(counter)) {
                return true;
            }

        }

        return false;
    }

    private boolean check(int[] counter) {
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

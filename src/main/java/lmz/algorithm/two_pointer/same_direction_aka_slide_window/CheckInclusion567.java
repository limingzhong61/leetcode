package lmz.algorithm.two_pointer.same_direction_aka_slide_window;

import java.util.Arrays;
import java.util.Locale;

public class CheckInclusion567 {
    /**
     * leetcode:滑动窗口-定长
     * 优化，用diff统计
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * leetcode:滑动窗口-定长
     */
    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(cnt1,cnt2)){
            return true;
        }
        for (int left = 0, right = n; right < m; ++right,++left) {
            --cnt2[s2.charAt(left) - 'a'];
            ++cnt2[s2.charAt(right) - 'a'];
            if(Arrays.equals(cnt1,cnt2)){
                return true;
            }
        }
        return false;
    }
    /**
     * leetcode:滑动窗口
     * 然后用两个指针 left 和 right 表示考察的区间
     * [,][left,right]。right 每向右移动一次，
     * 就统计一次进入区间的字符 x。为保证 cnt 的值不为正，若此时 cnt[x]>0，
     * 则向右移动左指针，减少离开区间的字符的 cnt 值直到 cnt[x]≤0。
     */
    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            /**
             * 保证 cnt 的值不为正，若此时 cnt[x]>0，则向右移动左指针，减少离开区间的字符的 cnt 值直到 cnt[x]≤0。
             */
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * 滑动窗口
     */
    public boolean checkInclusion1(String s1, String s2) {
        //    s1 和 s2 仅包含小写字母
        int[] map = new int[26];
        for (char item : s1.toCharArray()) {
            map[item - 'a']++;
        }
        char[] chars = s2.toCharArray();
        for (int left = 0, right = 0;left <= right && right <= chars.length; ) {
            boolean check = true;
            for (int i = 0; i < 26; i++) {
                if (map[i] > 0) {
                    if (right < chars.length)
                        map[chars[right++] - 'a']--;
                    else{ // 已经越界了
                        return false;
                    }
                    check = false;
                    break;
                } else if (map[i] < 0) {
                    map[chars[left++] - 'a']++;
                    check = false;
                    break;
                }
            }
            if (check) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion567 checkInclusion567 = new CheckInclusion567();

        testCase(checkInclusion567, "ab", "eidbaooo", true);
        testCase(checkInclusion567, "ab", "eidboaoo", false);
        testCase(checkInclusion567, "adc", "dcda", true);
    }

    private static void testCase(CheckInclusion567 checkInclusion567, String s1, String s2, boolean b) {
        System.out.println(checkInclusion567.checkInclusion(s1, s2));
        System.out.println(String.valueOf(checkInclusion567.checkInclusion(s1, s2) == b).toUpperCase(Locale.ROOT));
    }

}

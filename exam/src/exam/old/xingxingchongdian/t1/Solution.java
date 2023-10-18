package exam.old.xingxingchongdian.t1;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return int整型
     */
    public int Substrings(String str) {
        // write code here
        char[] cs = str.toCharArray();
        int n = cs.length;
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int left = i, right = i;
            while (left >= 0 && right <= n && cs[left] == cs[right]) {
                String mark = left + "-" + right;
                if (!set.contains(mark)) {
                    ans++;
                }
                set.add(mark);
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right <= n && cs[left] == cs[right]) {
                String mark = left + "-" + right;
                if (!set.contains(mark)) {
                    ans++;
                }
                set.add(mark);
                left--;
                right++;
            }
        }
        return ans;
    }
}

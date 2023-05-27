package lmz.algorithm.other.medium.old;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-01-08 12:20
 */
public class LengthOfLongestSubstringII016 {
    class Solution {
        /**
         * 维护[l,r]窗口，表示以l开始的不重复字符串
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
    /**
     * 双指针
     * [l,r)内保证无重复字符串。l,r都递增
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        // System.out.printf("-----------\n",maxLen,left,right);
        while (right < n) {
            if(!map.containsKey(cs[right])){
                map.put(cs[right],right++);
            }else{ // right重复
                int nextLeft = map.get(cs[right]) + 1;
                for(int i = left; i < nextLeft; i++){
                    map.remove(cs[i]);
                }
                left = nextLeft;
                map.put(cs[right],right++);
            }
            maxLen = Math.max(maxLen,right - left);
            // System.out.printf("maxLen=%d,left=%d,right=%d\n",maxLen,left,right);
        }
        return maxLen;
    }
}

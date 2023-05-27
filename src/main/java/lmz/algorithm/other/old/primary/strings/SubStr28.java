package lmz.algorithm.other.old.primary.strings;

//子字符串
public class SubStr28 {
    /**
     * leetcode :kmp 尝试
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        //构建next数组。next[i]表示index=i时的部分匹配匹配值。
        char[] pattern = (" " + needle).toCharArray();
        int patternLength = needle.length();
        int[] next = new int[patternLength + 1];
        for (int i = 2, j = 0; i <= patternLength; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && pattern[j + 1] != pattern[i]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++
            if (pattern[j + 1] == pattern[i]) { //同，部分匹配值（最长相等前后缀长度）+1
                j++;
            }
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }
        char[] s = (" " + haystack).toCharArray();
        for (int i = 1, j = 0; i < s.length; i++) {
            while (j > 0 && s[i] != pattern[j+1]) {
                j = next[j];
            }
            if(s[i] == pattern[j+1]) j++;
            if(j == patternLength) return i - patternLength;
        }
        //System.out.println(Arrays.toString(next));
        return -1;
    }

    /**
     * my:暴力搜索
     */
    public int strStr2(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); ) {
            int backIndex = i;
            int j;
            for (j = 0; i < haystack.length() && j < needle.length(); j++, i++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return backIndex;
            }
            i = backIndex + 1;
        }
        return -1;
    }

    /**
     * my:内置函数
     */
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        SubStr28 subStr28 = new SubStr28();
        System.out.println(subStr28.strStr("hello", "ll"));
        System.out.println(subStr28.strStr("aaaaa", "bba"));
        System.out.println(subStr28.strStr("", ""));
        System.out.println(subStr28.strStr("aaa", "aaaa"));
        System.out.println(subStr28.strStr("abeababeabf", "aaabbab"));

    }
}

package com.lmz.algorithm_practice.data_structure.string;

public class StrStr28 {

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = getNext(needle);
        int j = 0;
        char[] hayChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystack.length(); ) {
            if (hayChars[i] != needleChars[j]) {
                j = next[j];
                if(j ==  -1){ //最初位置j匹配不成功，下一个j位置应该是0，且i会移动到下一位
                    j = 0;
                    i++;
                }
                continue;
            }
            j++;
            i++;
            if (j == next.length) {
                return i - next.length;
            }
        }
        return -1;
    }

    public int[] getNext(String pattern) {
        return getNext(pattern.toCharArray());
    }

    public int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length];
        next[0] = -1;
        for (int i = 1; i < pattern.length; i++) {
            int nextJ = next[i - 1];
            while (nextJ != -1 && pattern[i - 1] != pattern[nextJ]) { //找到最小公共前缀
                nextJ = next[nextJ];
            }
            if (nextJ != -1) { //两者相等，此时next[i-1] == nextJ, 等价于chars[i-1] == chars[nextJ]
                next[i] = nextJ + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        StrStr28 strStr28 = new StrStr28();
        //System.out.println(Arrays.toString(strStr28.getNext("abaabca")));
        //System.out.println(Arrays.toString(strStr28.getNext("ACTGPACY")));
        //System.out.println(Arrays.toString(strStr28.getNext("abaabaab")));
        //System.out.println(Arrays.toString(strStr28.getNext("abcdabce")));

        System.out.println(strStr28.strStr("hello", "ll"));
        System.out.println(strStr28.strStr("hello", "ll") == 2);
        System.out.println(strStr28.strStr("aaaaa", "bba"));
        System.out.println(strStr28.strStr("aaaaa", "bba") == -1);
        System.out.println(strStr28.strStr("", ""));
        System.out.println(strStr28.strStr("", "") == 0);

        System.out.println(strStr28.strStr("a", "a"));
        System.out.println(strStr28.strStr("a", "a") == 0);

        System.out.println(strStr28.strStr("mississippi", "issip"));
        System.out.println(strStr28.strStr("mississippi", "issip") == 4);
    }
}

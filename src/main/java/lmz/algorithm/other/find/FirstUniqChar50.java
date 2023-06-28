package lmz.algorithm.other.find;

public class FirstUniqChar50 {
    /**
     * hashmap
     * s 只包含小写字母。
     */
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        for (char c : chars) {
            map[c - 'a']++;
        }
        for (char aChar : chars) {
            if (map[aChar - 'a'] == 1) {
                return aChar;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqChar50 firstUniqChar50 = new FirstUniqChar50();
        System.out.println(firstUniqChar50.firstUniqChar("leetcode"));
        System.out.println(firstUniqChar50.firstUniqChar(""));
    }
}

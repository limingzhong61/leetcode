package lmz.algorithm.recall;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String sub = s.substring(0, i);
            int j;
            for (j = i; j + i <= s.length(); j += i) {
                if (!sub.equals(s.substring(j, j + i))) {
                    break;
                }
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abacd"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("aabaaba"));
    }
}

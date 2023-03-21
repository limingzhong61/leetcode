package lmz.leetcode.data_structure.normal;

public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}

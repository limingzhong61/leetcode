package lmz.leetcode.other.easy;

/**
 * @author: codeofli
 * @create: 2022-11-03 9:23
 */
public class MaxRepeating1668 {
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        String s = word;
        for(int i = 1; s.length() <= sequence.length();  i++){
            if(sequence.contains(word)){
                max = i;
            }
            s = word.repeat(i+1);
        }
        return max;
    }
}

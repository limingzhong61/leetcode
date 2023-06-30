package lmz.algorithm.other.old.easy.old;

import java.util.Arrays;

public class MaxLengthBetweenEqualCharacters1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        //s 只含小写英文字母
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int maxLen = -1;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (map[idx] != -1) {
                maxLen = Math.max(maxLen, i - 1 - map[idx]);
            }else{ //只记录最开始的值
                map[idx] = i;
            }
        }
        return maxLen;
    }
}

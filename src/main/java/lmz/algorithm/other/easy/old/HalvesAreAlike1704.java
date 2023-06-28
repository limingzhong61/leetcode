package lmz.algorithm.other.easy.old;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: codeofli
 * @create: 2022-11-11 9:11
 */
public class HalvesAreAlike1704 {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int half = s.length() / 2;
        int leftCnt = 0,rightCnt = 0;
        for(int i = 0; i < half; i++){
            if(set.contains(s.charAt(i))){
                leftCnt++;
            }
        }
        for(int i = half; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                rightCnt++;
            }
        }
        return leftCnt == rightCnt;
    }
}

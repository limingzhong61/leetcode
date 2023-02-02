package lmz.leetcode.other.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-01-11 15:38
 */
public class DigitCount2283 {
    public boolean digitCount(String num) {
        int[] map = new int[10];
        for(char c : num.toCharArray()){
            map[c - '0']++;
        }
        for(int i = 0; i < num.length(); i++){
            if(map[i] != num.charAt(i) - '0'){
                return  false;
            }
        }
        return true;
    }
}

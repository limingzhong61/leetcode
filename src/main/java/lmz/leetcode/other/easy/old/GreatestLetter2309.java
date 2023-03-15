package lmz.leetcode.other.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-01-27 12:59
 */
public class GreatestLetter2309 {
    public String greatestLetter(String s) {
        int letterLen = 26;
        boolean[] upCase = new boolean[letterLen];
        boolean[] lowCase = new boolean[letterLen];
        for(var c : s.toCharArray()){
            if(Character.isLowerCase(c)){
                lowCase[c - 'a'] = true;
            }else {
                upCase[c-'A'] = true;
            }
        }
        for(int i = letterLen - 1; i >= 0; i--){
            if(upCase[i] && lowCase[i]){
                return String.valueOf((char)(i + 'A'));
            }
        }
        return "";
    }
}

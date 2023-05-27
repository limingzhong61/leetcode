package lmz.algorithm.contest.old;

public class GreatestLetter5242 {
    public String greatestLetter(String s) {
        int[] small = new int[26];
        int[] big = new int[26];
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(Character.isUpperCase(chars[i])){
                big[chars[i]- 'A']++;
            }else{
                small[chars[i]- 'a']++;
            }
        }
        for(int i = 25; i >= 0; i--){
            if(big[i] > 0 && small[i] > 0){
                return String.valueOf((char) (i+ 'A'));
            }
        }
        return "";
    }
}

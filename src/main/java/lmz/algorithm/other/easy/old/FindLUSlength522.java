package lmz.algorithm.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-11-04 21:59
 */
public class FindLUSlength522 {
    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        for(var s : strs){
            boolean success = true;
            for(var s2 : strs){
                if(s != s2 && isSubStr(s,s2)){
                    success = false;
                    break;
                }
            }
            if(success){
                maxLen = Math.max(maxLen,s.length());
            }
        }
        return maxLen;
    }

    private boolean isSubStr(String pattern, String str) {
        int start = 0;
        for(var c : str.toCharArray()){
            if(c == pattern.charAt(start)){
                start++;
                if(start == pattern.length()){
                    return true;
                }
            }
        }
        return false;
    }
}

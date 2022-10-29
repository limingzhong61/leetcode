package codeofli.leetcode.other.easy.old;

/**
 * @author: limingzhong
 * @create: 2022-10-23 9:48
 */
public class MergeAlternately1768 {
    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length() > len ){
            sb.append(word1.substring(len));
        }
        if(word2.length() > len ){
            sb.append(word2.substring(len));
        }
        return sb.toString();
    }
}

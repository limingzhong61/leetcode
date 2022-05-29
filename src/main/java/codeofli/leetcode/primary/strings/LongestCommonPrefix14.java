package codeofli.leetcode.primary.strings;

public class LongestCommonPrefix14 {
    //纵向扫描
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int length  =strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for(int j =1; j < strs.length; j++){
                if(i >= strs[j].length() || c != strs[j].charAt(i)){
                    return  sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

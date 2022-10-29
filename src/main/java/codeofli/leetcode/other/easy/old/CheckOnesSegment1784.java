package codeofli.leetcode.other.easy.old;

public class CheckOnesSegment1784 {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                while(i + 1 < s.length() && s.charAt(i+1) == '1'){
                    i++;
                }
                cnt++;
            }
        }
        return cnt <= 1;
    }
}

package lmz.leetcode.other.old.loop;

public class AreAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
    //    s1 和 s2 仅由小写英文字母组成
        int[] diff = new int[26];
        int diffCnt = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff[s1.charAt(i) - 'a']++;
                diff[s2.charAt(i) - 'a']--;
                diffCnt++;
                if(diffCnt > 2){
                    return  false;
                }
            }
        }
        for(int item : diff){
            if(item != 0){
                return false;
            }
        }
        return true;
    }
}

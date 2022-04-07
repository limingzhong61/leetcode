package mars.leetcode.primary.strings;

public class IsAnagram242 {

    public boolean isAnagram(String s, String t) {
        //长度不同
        if(s.length() != t.length()){
            return false;
        }
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();
        //都是小写字母
        int[] map = new int[26];
        int length = sCh.length;
        for(int i = 0; i < length; i++){
            map[sCh[i]-'a']++;
            map[tCh[i]-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(map[i] != 0){
                return  false;
            }
        }
        return true;
    }
    //leetcode

    /**
     *
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}

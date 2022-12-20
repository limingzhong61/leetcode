package lmz.leetcode.data_structure.string;

public class CanConstruct383 {
    /**
     * hashmap
     * ransomNote 和 magazine 由小写英文字母组成
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(var item : ransomNote.toCharArray()){
            map[item - 'a']++;
        }
        for(var item : magazine.toCharArray()){
            map[item - 'a']--;
        }
        for(var item : map){
            if(item > 0){
                return false;
            }
        }
        return true;
    }
}

package lmz.algorithm.data_structure.string;

import java.util.*;

public class WordPattern290 {
    /**
     * hashmap
     * 注："abba"
     * "dog dog dog dog"是错的，不存在<a,dog>和<b,dog>
     */
    public boolean wordPattern(String pattern, String s) {
        String[] splits = s.split(" ");
        if (pattern.length() != splits.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(splits[i]) ) {
                    return false;
                }
            }else{
                if(map.containsValue(splits[i])){ //不存在<a,dog>和<b,dog>
                    return false;
                }else{
                    map.put(pattern.charAt(i), splits[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern290 wordPattern290 = new WordPattern290();
        System.out.println(wordPattern290.wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern290.wordPattern("abba", "dog dog dog dog"));
    }
}

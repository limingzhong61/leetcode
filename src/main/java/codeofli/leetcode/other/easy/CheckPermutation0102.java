package codeofli.leetcode.other.easy;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation0102 {
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}

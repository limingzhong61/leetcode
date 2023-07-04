package lmz.algorithm.other.easy.old;

import java.util.HashMap;
import java.util.Map;

public class IsAlienSorted953 {
    /**
     * 空白字符，定义为比任何其他字符都小
     */
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 1;
        for (char c : order.toCharArray()) {
            map.put(c, index++);
        }
        for (int i = 1; i < words.length; i++) {
            int m = words[i - 1].length(), n = words[i].length();
            int len = Math.min(m, n);
            boolean equal = true;
            for (int j = 0; j < len; j++) {
                Integer aValue = map.get(words[i - 1].charAt(j));
                Integer bValue = map.get(words[i].charAt(j));
                if(aValue == bValue){
                    continue;
                }
                if (aValue > bValue) {
                    return false;
                }else{
                    equal = false;
                    break;
                }
            }
            // 如果前面都相等，则判断长度
            if (equal && words[i].length() < words[i - 1].length()) {
                return false;
            }
        }

        return true;
    }
}

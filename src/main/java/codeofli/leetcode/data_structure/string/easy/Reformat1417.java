package codeofli.leetcode.data_structure.string.easy;

import java.util.ArrayList;
import java.util.List;

public class Reformat1417 {
    /**
     * 1 <= s.length <= 500
     * s 仅由小写英文字母和/或数字组成。
     */
    public String reformat(String s) {
        int len = s.length();
        List<Character> charList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(cs[i])) {
                charList.add(cs[i]);
            } else {
                numList.add(cs[i]);
            }
        }
        List<Character> longList = null, shortList = null;
        if (charList.size() >= numList.size() && charList.size() - numList.size() <= 1) {
            longList = charList;
            shortList = numList;
        } else if (numList.size() - charList.size() <= 1) {
            longList = numList;
            shortList = charList;
        }else {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortList.size(); i++) {
            sb.append(longList.get(i));
            sb.append(shortList.get(i));
        }
        if(longList.size() > shortList.size() ){ // 长的多了一个
            sb.append(longList.get(longList.size()-1));
        }
        return sb.toString();
    }
}

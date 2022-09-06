package codeofli.leetcode.unc_good;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString828 {
    /**
     * lc：分别计算每个字符的贡献
     * 一个字符c，记当前位置ci，前一个c的位置为cj，后一个c位置为ck
     * 则在【ci，cj）的全部子串中都有一个c，同理【cj，ck）的全部子串中都有一个c
     */
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }


    public static void main(String[] args) {
        UniqueLetterString828 uniqueLetterString828 = new UniqueLetterString828();
        System.out.println(uniqueLetterString828.uniqueLetterString("ABC"));
    }
}

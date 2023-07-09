package com.lmz.algorithm.hash;

import java.util.*;

public class FindRepeatedDnaSequences {
    static final int L = 10;
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    /**
     * 哈希表 + 滑动窗口 + 位运算
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        int n = s.length();
        if (n <= L) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n - L; ++i) {
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }

    /**
     * hash
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i = 0; i <= s.length()-10; i++){
            String temp = s.substring(i, i + 10);
            if(set.contains(temp)){
                res.add(temp);
            }else {
                set.add(temp);
            }
        }
        return  Arrays.asList(res.toArray(res.toArray(new String[0])));
    }
}

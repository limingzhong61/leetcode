package com.lmz.algorithm.p.p_1000_2000;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-08-05 19:22
 */
public class MaxVowels1456 {
    public int maxVowels(String s, int k) {
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        set.addAll(List.of('a', 'e', 'i', 'o', 'u'));
        for(int i = 0; i < k; i++){
            if(set.contains(s.charAt(i))){
                cnt++;
            }
        }
        int ans = cnt;
        for(int i = k; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                cnt++;
            }
            if(set.contains(s.charAt(i-k))){
                cnt--;
            }
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}

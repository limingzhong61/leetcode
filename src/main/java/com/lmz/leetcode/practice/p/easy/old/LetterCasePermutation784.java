package com.lmz.leetcode.practice.p.easy.old;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: codeofli
 * @create: 2022-10-30 9:13
 */
public class LetterCasePermutation784 {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] cs = s.toCharArray();
        dfs(s,cs,0);
        return  res;
    }

    private void dfs(String s, char[] cs,int cur ) {
        if(cur == s.length()){
            res.add(String.valueOf(cs));
            return ;
        }
        if(Character.isLetter(cs[cur])){
            cs[cur] = Character.toUpperCase(cs[cur]);
            dfs(s,cs,cur + 1);
            cs[cur] = Character.toLowerCase(cs[cur]);
            dfs(s,cs,cur + 1);
        }
    }
}

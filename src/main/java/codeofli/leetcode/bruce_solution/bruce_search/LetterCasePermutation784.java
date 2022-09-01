package codeofli.leetcode.bruce_solution.bruce_search;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    /**
     * 搜索
     */
    public List<String> letterCasePermutation(String s) {
        search(s.toCharArray(),0);
        return res;
    }
    List<String> res = new ArrayList<>();
    private void search(char[] cs, int i) {
        if(i == cs.length){
            res.add(String.valueOf(cs));
            return;
        }
        if(Character.isLetter(cs[i])){
            cs[i] = Character.toLowerCase(cs[i]); //选择为小写
            search(cs,i+1);
            cs[i] = Character.toUpperCase(cs[i]); //选择为大写
            search(cs,i+1);
        }else{
            search(cs,i+1);
        }
    }
}

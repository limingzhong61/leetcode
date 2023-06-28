package lmz.algorithm.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-11 19:51
 */
public class LetterCombinations17 {
    public List<String> letterCombinations(String digits) {
        String[] num= new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> ans = new ArrayList<>();
        path = new char[digits.length()];
        dfs(digits,num,ans,0);
        return ans;
    }

    char[] path;
    private void dfs(String digits, String[] num, ArrayList<String> ans,int cur) {
        if(cur == digits.length()) {
            ans.add(new String(path));
            return;
        }
        for(int i = 0; i < num.length; i++){
            path[cur] = num[cur].charAt(i);
            dfs(digits,num,ans,cur);
        }
    }
}

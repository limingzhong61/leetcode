package lmz.algorithm.recall.conbine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-06-16 14:36
 */
public class GenerateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        dfs(n,n);
        return  ans;
    }
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    private void dfs(int left, int right) {
        if(left < 0 || right < 0 || left > right){ //前面右括号多
            return;
        }
        if(left == 0 && right == 0){
            ans.add(sb.toString());
        }
        // 左括号
        sb.append('(');
        dfs(left-1,right);
        sb.deleteCharAt(sb.length()-1);
        //右括号
        sb.append(')');
        dfs(left,right-1);
        sb.deleteCharAt(sb.length()-1);
    }
}

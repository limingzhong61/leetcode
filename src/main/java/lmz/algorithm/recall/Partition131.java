package lmz.algorithm.recall;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-15 22:37
 */
public class Partition131 {
    char[] cs;
    List<List<String>> ans;
    int n = 0;

    /**
     * 假设每对相邻字符之间有个逗号，那么就看每个逗号是选还是不选。
     */
    public List<List<String>> partition(String s) {
        cs = s.toCharArray();
        n = cs.length;
        dfs(0);
        Iterator<List<String>> iterator = ans.iterator();
        while(iterator.hasNext()){
            List<String> next = iterator.next();
            if(next.size() == 0) iterator.remove();
        }
        return ans;
    }

    StringBuilder path = new StringBuilder();

    private void dfs(int i) {
        if (i == n) {
            for (int a = 0, b = cs.length - 1; a < b; a++, b--) {
                if (path.charAt(a) != path.charAt(b)) return;
            }
            List<String> list = new ArrayList<>();
            list.add(path.toString());
            ans.add(list);
        }
        // 不选
        dfs(i + 1);
        // 选
        path.append(cs[i]);
        dfs(i + 1);
        path.deleteCharAt(path.length()-1); // 恢复现场
    }
}

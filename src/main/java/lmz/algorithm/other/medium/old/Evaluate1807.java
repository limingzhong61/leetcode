package lmz.algorithm.other.medium.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-01-12 13:59
 */
public class Evaluate1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        char[] cs = s.toCharArray();
        int n = s.length();
        Map<String,String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0),list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(cs[i] == '('){
                int j = i + 1;
                while(j < n && cs[j] != ')'){
                    j++;
                }
                String find = s.substring(i + 1, j);
                String replace = map.get(find);
                if(replace != null){
                    sb.append(replace);
                }else{
                    sb.append("?");
                }
                i = j;
            }else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}

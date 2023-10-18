package exam.yaxinanquan.t1;


import com.sun.javafx.scene.transform.TransformUtils;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pos string字符串一维数组
     * @return int整型
     */
    public int getMaxCount (String[] pos) {
        int ans = 0, n = pos.length;
        if(pos.length == 1){
            return "B".equals(pos[0]) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            if (pos[i].equals("A")) {
                continue;
            } else {
                if (i == 0 ) {
                    if("B".equals(pos[i + 1]) ){
                        ans++;
                        pos[i] = "A";
                    }
                } else if (i == n - 1) {
                    if("B".equals(pos[i - 1])){
                        ans++;
                        pos[i] = "A";
                    }
                } else if ("B".equals(pos[i - 1]) && "B".equals(pos[i + 1])) {
                    ans++;
                    pos[i] = "A";
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxCount(new String[]{"A", "B", "B", "B", "A"}));
        System.out.println(solution.getMaxCount(new String[]{"B", "B", "B"}));
        System.out.println(solution.getMaxCount(new String[]{"B", "B"}));
        System.out.println(solution.getMaxCount(new String[]{"A", "B"}));
        System.out.println(solution.getMaxCount(new String[]{"B", "A"}));
    }
}

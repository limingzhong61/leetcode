package lmz.algorithm.other.medium.old;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2023-03-03 8:05
 */
public class GetFolderNames1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        int idx = 0;
        for (String s : names) {
            if (!map.containsKey(s)) {
                map.put(s, 0);
                res[idx++] = s;
            } else {
                int nextNum = map.get(s) + 1;
                String next = s + '(' + nextNum + ')';
                while (map.containsKey(next)) {
                    next = s + '(' + nextNum + ')';
                    nextNum++;
                }
                res[idx++] = next;
                map.put(s, nextNum);
                map.put(next,0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GetFolderNames1487 getFolderNames1487 = new GetFolderNames1487();
        System.out.println(Arrays.toString(getFolderNames1487.getFolderNames(
                TransformUtil.toStringArray("[\"kaido\",\"kaido(1)\",\"kaido\",\"kaido(1)\",\"kaido(2)\"]"))));
    }
}





























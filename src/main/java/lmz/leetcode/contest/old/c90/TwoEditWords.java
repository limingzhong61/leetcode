package lmz.leetcode.contest.old.c90;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.*;

/**
 * @author: codeofli
 * @create: 2022-10-29 22:44
 */
public class TwoEditWords {
    Set<String> set = new HashSet<>();

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries[0].length();
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(var s1  : queries){
            int diff = 0;
            for(var s2 : dictionary){
                for(int i = 0; i < n; i++){
                    if(s1.charAt(i) != s2.charAt(i)){
                        diff++;
                    }
                }
                if(diff <= 2){
                    if (!set.contains(s1)) {
                        res.add(s1);
                    }
                    set.add(s1);

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoEditWords twoEditWords = new TwoEditWords();
        System.out.println(twoEditWords.twoEditWords(TransformUtil.toStringArray("[\"word\",\"note\",\"ants\",\"wood\"]"),
                TransformUtil.toStringArray("[\"wood\",\"joke\",\"moat\"]\n" +
                        "[\"yes\"]")));
    }
}

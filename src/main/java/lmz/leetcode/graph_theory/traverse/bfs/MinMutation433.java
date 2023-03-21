package lmz.leetcode.graph_theory.traverse.bfs;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class MinMutation433 {
    /**
     dfs
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        char[] startChars = start.toCharArray();
        char[] endChars = end.toCharArray();
        int changeCnt = 0;
        minCnt = Integer.MAX_VALUE;
        dfs(startChars, endChars, set, changeCnt);

        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }

    //其中每个字符都是 'A'、'C'、'G' 和 'T' 之一
    char[] changes = new char[]{'A', 'C', 'G', 'T'};
    int minCnt = Integer.MAX_VALUE;

    private void dfs(char[] startChars, char[] endChars, Set<String> set, int changeCnt) {
        if (changeCnt > set.size()) {
            return;
        }
        if (Arrays.equals(startChars, endChars)) {
            minCnt = Math.min(changeCnt, minCnt);
            return;
        }
        for (int cur = 0; cur < startChars.length; cur++) {
            for (int i = 0; i < changes.length; i++) {
                if (startChars[cur] == changes[i]) {
                    continue;
                }
                char originalChar = startChars[cur];
                startChars[cur] = changes[i];
                String tempStr = String.valueOf(startChars);
                if (set.contains(tempStr)) {
                    dfs(startChars, endChars, set, changeCnt + 1);
                }
                startChars[cur] = originalChar; //还原；
            }
        }
    }

    public static void main(String[] args) {
        MinMutation433 minMutation433 = new MinMutation433();

        testCase(minMutation433, "AACCGGTT", "AACCGGTA", "[\"AACCGGTA\"]", 1);
        testCase(minMutation433, "AACCGGTT", "AAACGGTA", "[\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]", 2);
        testCase(minMutation433, "AAAAACCC", "AACCCCCC", "[\"AAAACCCC\",\"AAACCCCC\",\"AACCCCCC\"]", 3);
        testCase(minMutation433, "AAAAACCC", "AACCCCCC", "", -1);
        testCase(minMutation433, "AACCGGTT", "AAACGGTA", "[\"AACCGATT\",\"AACCGATA\",\"AAACGATA\",\"AAACGGTA\"]", 4);
        testCase(minMutation433, "AACCGGTT", "AACCGCTA", "[\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]", 2);
        testCase(minMutation433, "AAAAAAAA", "CCCCCCCC", "[\"AAAAAAAA\",\"AAAAAAAC\",\"AAAAAACC\",\"AAAAACCC\",\"AAAACCCC\",\"AACACCCC\"" +
                ",\"ACCACCCC\",\"ACCCCCCC\",\"CCCCCCCA\",\"CCCCCCCC\"]", 8);
    }

    private static void testCase(MinMutation433 minMutation433, String start, String end, String s, int i) {

        System.out.println(minMutation433.minMutation(start, end,
                TransformUtil.toStringArray(s)));
        System.out.println(minMutation433.minMutation(start, end,
                TransformUtil.toStringArray(s)) == i);
    }
}

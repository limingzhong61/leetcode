package lmz.leetcode.other.intro;

import lmz.my.leetcode.TransformUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class WordBreak139 {
    /**
     * leetcode优化：dp[i]只需要往前探索到词典里最长的单词即可
     * dp[i]表示s[0,i-1]能否由wordDict构成
     * dp[i] = dp[j] && wordDict.contains(s.substring(j,i))
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(),maxWordLen = 0;
        Set<String> wordDictSet = new HashSet(wordDict);
        for(String str : wordDict){
            wordDictSet.add(str);
            maxWordLen = Math.max(maxWordLen, str.length());
        }
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = i; j >= i - maxWordLen && j >= 0; j--){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; // 有一个就行了
                }
            }
        }
        return dp[n];
    }
    /**
     * dp[i]表示s[0,i-1]能否由wordDict构成
     * dp[i] = dp[j] && wordDict.contains(s.substring(j,i))
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; // 有一个就行了
                }
            }
        }
        return dp[n];
    }
    public class Trie {
        boolean isFinished;
        Trie[] child;

        public Trie() {
            isFinished = false;
            child = new Trie[26];
        }

        public Trie(String[] dictionary) {
            this();
            for (String s : dictionary) {
                Trie cur = this;
                for (char c : s.toCharArray()) {
                    int cIndex = c - 'a';
                    Trie nextChild = cur.child[cIndex];
                    if (nextChild == null) {
                        cur.child[cIndex] = new Trie();
                    }
                    cur = cur.child[cIndex];
                }
                cur.isFinished = true;
            }
        }

        public Trie(List<String> dictionary) {
            this(dictionary.toArray(new String[0]));
        }
    }

    /**
     * 字典树+记忆化搜索
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        this.trie = new Trie(wordDict);
        dp = new int[s.length()+1];
        return search(trie, s, 0) == 1;
    }

    Trie trie;
    int[] dp ;
    private int search(Trie node, String s, int pos) {
        if(dp[pos] != 0){
            return dp[pos] ;
        }
        if (pos == s.length()) {
            //System.out.println(trie == node);
            return trie == node ? 1 : -1;
        }

        for (int i = 0; i < node.child.length; i++) {
            if (node.child[i] != null && i + 'a' == s.charAt(pos)) {
                if (node.child[i].isFinished) {
                    if (search(trie, s, pos + 1) == 1) {
                        return dp[pos] = 1;
                    }
                }

                if (search(node.child[i], s, pos + 1) == 1) {
                    return dp[pos] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();
        testCase(wordBreak139, "leetcode", "[\"leet\", \"code\"]",true);
        testCase(wordBreak139, "applepenapple", " [\"apple\", \"pen\"]",true);
        testCase(wordBreak139, "catsandog", " [\"cats\", \"dog\", \"sand\", \"and\", \"cat\"]",false);
        testCase(wordBreak139, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "[\"a\",\"aa\",\"aaa\",\"aaaa\",\"aaaaa\"," +
                "\"aaaaaa\",\"aaaaaaa\",\"aaaaaaaa\",\"aaaaaaaaa\",\"aaaaaaaaaa\"]",false);
        testCase(wordBreak139, "aaaaaaa", "[\"aaaa\",\"aaa\"]",true);
    }

    private static void testCase(WordBreak139 wordBreak139, String applepenapple, String s, boolean b) {
        System.out.println(wordBreak139.wordBreak(applepenapple, TransformUtil.toStringArrayList(s)));
        System.out.println(String.valueOf(wordBreak139.wordBreak(applepenapple, TransformUtil.toStringArrayList(s)) == b).toUpperCase(Locale.ROOT));
    }
}

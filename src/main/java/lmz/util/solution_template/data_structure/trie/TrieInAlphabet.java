package lmz.util.solution_template.data_structure.trie;

/**
 * （小写字母）字典树
 * 其中只包含小写字母
 */
public class TrieInAlphabet {
    boolean isFinished;
    TrieInAlphabet[] child;

    public TrieInAlphabet() {
        isFinished = false;
        child = new TrieInAlphabet[26];
    }

    public TrieInAlphabet(String[] dictionary) {
        this();
        for (String s : dictionary) {
            TrieInAlphabet cur = this;
            for (char c : s.toCharArray()) {
                int cIndex = c - 'a';
                TrieInAlphabet nextChild = cur.child[cIndex];
                if (nextChild == null) {
                    cur.child[cIndex] = new TrieInAlphabet();
                }
                cur = cur.child[cIndex];
            }
            cur.isFinished = true;
        }

    }

    /**
     * leetcode:方法一：枚举每个字典中的字符串并判断
     * list存储，遍历匹配
     */
    class MagicDictionary {
        TrieInAlphabet tire;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            tire = new TrieInAlphabet(dictionary);
        }

        public boolean search(String searchWord) {
            return search(searchWord, 0, tire, false);
        }

        /**
         * 当前遍历到的字典树上的节点是 node 以及待查询字符串 searchWord 的第 pos 个字符，并且在之前的遍历中是否已经替换过恰好一个字符（如果替换过，
         * 那么 modified 为 true，否则为 false）。
         */
        private boolean search(String searchWord, int pos, TrieInAlphabet node, boolean modified) {
            if (pos == searchWord.length()) {
                return modified && node.isFinished;
            }
            int idx = searchWord.charAt(pos) - 'a';
            if (node.child[idx] != null) {
                if (search(searchWord, pos + 1, node.child[idx], modified)) {
                    return true;
                }
            }
            if (!modified) {
                for (int i = 0; i < 26; i++) {
                    if (i != idx && node.child[i] != null) {
                        if (search(searchWord, pos + 1, node.child[i], true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}

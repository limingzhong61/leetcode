package lmz.algorithm.graph.traverse.bfs;

import lmz.my.leetcode.TransformUtil;

import java.util.*;

public class LadderLength127 {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    /**
     * leetcode:广度优先搜索 + 优化建图
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }

    /**
     * BFS，每次set判断能到达才加入queue，并从能到达的set中删除该状态
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> cntQueue = new LinkedList<>();
        queue.add(beginWord);
        cntQueue.add(1);
        int n = beginWord.length();
        while (!queue.isEmpty()) {
            char[] chars = queue.poll().toCharArray();
            Integer cnt = cntQueue.poll();
            for (int i = 0; i < n; i++) {
                char originalChar = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    if (String.valueOf(chars).equals(endWord)) {
                        return cnt + 1;
                    }
                    if (set.contains(String.valueOf(chars))) {
                        set.remove(String.valueOf(chars));
                        queue.add(String.valueOf(chars));
                        cntQueue.add(cnt + 1);
                    }
                }
                chars[i] = originalChar;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LadderLength127 ladderLength127 = new LadderLength127();

        System.out.println(ladderLength127.ladderLength("hit", "cog",
                TransformUtil.toStringArrayList("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]")));
        System.out.println(ladderLength127.ladderLength("hit", "cog",
                TransformUtil.toStringArrayList("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]")) == 0);

        System.out.println(ladderLength127.ladderLength("hit", "cog",
                TransformUtil.toStringArrayList("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]")));
        System.out.println(ladderLength127.ladderLength("hit", "cog",
                TransformUtil.toStringArrayList("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]")) == 0);
    }
}

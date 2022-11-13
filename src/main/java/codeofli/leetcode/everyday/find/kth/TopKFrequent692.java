package codeofli.leetcode.everyday.find.kth;

import java.util.*;

public class TopKFrequent692 {
    /**
     * Map统计，直接排序
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        Pair[] pairs = new Pair[map.size()];
        int index = 0;
        for(var entry : map.entrySet()){
            pairs[index++] = new Pair(entry.getValue(),entry.getKey());
        }
        Arrays.sort(pairs,(a,b)->{
            if(a.count == b.count){
                return a.word.compareTo(b.word);
            }
            return b.count - a.count;
        });
        List<String> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(pairs[i].word);
        }
        return res;
    }

    class Pair{
        int count = 0;
        String word;
        Pair(int count,String word){
            this.count = count;
            this.word = word;
        }
    }
}

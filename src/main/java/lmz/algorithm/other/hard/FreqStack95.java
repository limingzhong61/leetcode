package lmz.algorithm.other.hard;

import java.util.*;

/**
 * @author: codeofli
 * @create: 2022-11-30 9:44
 */
public class FreqStack95 {
    /**
     * lc:双hash
     */
    class FreqStack {
        private Map<Integer, Integer> freq;
        private Map<Integer, Deque<Integer>> group;
        private int maxFreq;

        public FreqStack() {
            freq = new HashMap<Integer, Integer>();
            group = new HashMap<Integer, Deque<Integer>>();
            maxFreq = 0;
        }

        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            group.putIfAbsent(freq.get(val), new ArrayDeque<Integer>());
            group.get(freq.get(val)).push(val);
            maxFreq = Math.max(maxFreq, freq.get(val));
        }

        public int pop() {
            int val = group.get(maxFreq).peek();
            freq.put(val, freq.get(val) - 1);
            group.get(maxFreq).pop();
            if (group.get(maxFreq).isEmpty()) {
                maxFreq--;
            }
            return val;
        }
    }


    class FreqStack1 {
        TreeMap<Integer, Deque<Integer>> freqMap = new TreeMap<>();
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        public FreqStack1() {

        }

        public void push(int val) {
            Integer cnt = cntMap.get(val);
            if(cnt == null){
                cntMap.put(val,1);
                Deque<Integer> deque = freqMap.getOrDefault(1, new ArrayDeque<>());
                deque.addLast(val);
                freqMap.put(1,deque);
            }else{ //因为需要之前的最接近栈顶的顺序，所以不用删除之前次数的记录
                cntMap.put(val,cnt +1);
                Deque<Integer> addDeque = freqMap.getOrDefault(cnt+1, new ArrayDeque<>());
                addDeque.addLast(val);
                freqMap.put(cnt+1,addDeque);
            }
        }

        public int pop() {
            int freq = freqMap.lastEntry().getKey();
            Deque<Integer> deque = freqMap.lastEntry().getValue();
            int res = deque.removeLast();
            freqMap.put(freq,deque);
            if(deque.size() == 0){
                freqMap.remove(freqMap.lastEntry().getKey());
            }
            if(freq == 1){
                cntMap.remove(res);
            }else{
                cntMap.put(res,freq - 1);
                Deque<Integer> addDeque = freqMap.getOrDefault(freq - 1, new ArrayDeque<>());
                addDeque.addLast(res);
                freqMap.put(freq -1,addDeque);
            }
            return res;
        }
    }
}

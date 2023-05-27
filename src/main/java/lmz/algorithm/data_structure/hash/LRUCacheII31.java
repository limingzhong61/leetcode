package lmz.algorithm.data_structure.hash;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheII31 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            //accessOrder为true
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}

package test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author: limingzhong
 * @create: 2024-05-29 15:58
 */
class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int capacity = 0;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer val = cache.get(key);
        if(val != null){
            cache.remove(key);
            cache.put(key,val);
        }
        return val == null ? -1 :val;
    }

    public void put(int key, int value) {
        if(cache.size() == capacity){
            Integer first = 0;
            for(Integer x : cache.keySet()){
                first = x;
                break;
            }
            cache.remove(first);
        }
        cache.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

    }
}
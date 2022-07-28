package codeofli.leetcode.data_structure;

import java.util.ArrayList;
import java.util.Arrays;

public class MyHashMap706 {
    /**
     * 0 <= key, value <= 10^6
     */
    class MyHashMap {
        int[] map = new int[1000003];

        public MyHashMap() {
            Arrays.fill(map, -1);
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public int get(int key) {
            return map[key];
        }

        public void remove(int key) {
            map[key] = -1;
        }
    }
}

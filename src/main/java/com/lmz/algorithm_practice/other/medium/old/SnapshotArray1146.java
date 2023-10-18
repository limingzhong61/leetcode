package com.lmz.algorithm_practice.other.medium.old;

import java.util.TreeMap;

public class SnapshotArray1146 {
    /**
     * 利用TreeMap二分查找：
     * 每次snap都会复制整个数组snapId++；
     */
    class SnapshotArray {
        TreeMap<Integer,Integer>[] arr;
        int snapId = 0;
        public SnapshotArray(int length) {
           arr = new TreeMap[length];
           for(int i = 0; i < length; i++){
               arr[i] = new TreeMap<>();
               arr[i].put(0, 0); //此时每次idx = i的0版本都为0
           }
        }

        public void set(int index, int val) {
            arr[index].put(snapId,val);
        }
        //返回当前快照snapId，snapId++；
        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return arr[index].floorEntry(snap_id).getValue();
        }
    }
}

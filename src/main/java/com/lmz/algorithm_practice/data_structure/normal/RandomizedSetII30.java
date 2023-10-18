package com.lmz.algorithm_practice.data_structure.normal;

import java.util.*;

public class RandomizedSetII30 {
    /**
     * 方法一：变长数组 + 哈希表
     *
     * 关键： 变长数组和hash同步删除：删除一个元素后，在变长数组中用最后一个元素覆盖被删除的元素的位置,
     * 注意：同步map操作，删除元素，更新最后一个元素的index；
     */
    class RandomizedSet {

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random random =new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            map.put(val,list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return  false;
            }
            int index = map.get(val);
            Integer lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            list.remove(list.size()-1);

            //map同步更新
            map.put(lastVal,index);
            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        //public int getRandom() {
        //    int randomIndex = random.nextInt(0,list.size());
        //    return list.get(randomIndex);
        //}
    }
}

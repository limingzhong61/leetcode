package lmz.algorithm.find.dynamic_find;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: limingzhong
 * @create: 2023-03-20 10:32
 */
public class MyCalendarII058 {
    /**
     * 动态查找
     */
    class MyCalendar {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> ceil = treeMap.ceilingEntry(start);
            Map.Entry<Integer, Integer> low = treeMap.lowerEntry(start);
            if(ceil != null){
                if(!(end <= ceil.getKey() || ceil.getValue() <= start)){
                    return  false;
                }
            }
            if(low != null){
                if(!(end <= low.getKey() || low.getValue() <= start)){
                    return  false;
                }
            }
            treeMap.put(start,end);
            return true;
        }
    }
}

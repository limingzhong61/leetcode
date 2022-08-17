package codeofli.leetcode.other.class_object;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream1656 {
    class OrderedStream {
        int ptr = 1;
        String[] elements;

        public OrderedStream(int n) {
            elements = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            elements[idKey] = value;
            List<String> res = new ArrayList<>();
            if (ptr == idKey) {
                while(ptr < elements.length && elements[ptr] !=null){
                    res.add(elements[ptr]);
                    ptr++;
                }
            }
            return res;
        }
    }
}

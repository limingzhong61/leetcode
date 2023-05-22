package lmz.my;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //Integer i = null;
        //System.out.println(i == 0);
        //HashMap<Integer,Integer> a = new HashMap<>(10);
        //a.put(1,0);
        //a.put(1,1);
        //System.out.println(a.get(1));
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for(Iterator<Integer> i1 = list.iterator(); i1.hasNext();){
            for(Iterator<Integer> i2 = list.iterator(); i2.hasNext();){
                sum += i1.next() + i2.next();
            }
        }
        System.out.println(sum);
    }
}

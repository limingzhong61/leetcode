package lmz.my;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        //Integer i = null;
        //System.out.println(i == 0);
        HashMap<Integer,Integer> a = new HashMap<>(10);
        a.put(1,0);
        a.put(1,1);
        System.out.println(a.get(1));
        //System.out.println(10^5);
    }
}

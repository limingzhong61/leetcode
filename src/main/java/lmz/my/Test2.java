package lmz.my;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Test2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Integer i = null;
        //System.out.println(i == 0);
        //HashMap<Integer,Integer> a = new HashMap<>(10);
        //a.put(1,0);
        //a.put(1,1);
        //System.out.println(a.get(1));
        Printer p = new FastPrinter();
        p.value = 2;
        p.print();
        Class<?> clazz = Class.forName("java.lang.String");
        Constructor<?> constructor = clazz.getConstructor();
        Object o = constructor.newInstance("123");
        System.out.println(o);

        //ArrayList<Printer> c= new ArrayList<FastPrinter>();
        ArrayList<? extends Printer> d= new ArrayList<FastPrinter>();
        ArrayList< ? super  FastPrinter> b= new ArrayList<FastPrinter>();
        ArrayList< ? super  FastPrinter> l= new ArrayList<Printer>();
        HashMap<Integer,Integer> a = new HashMap<>();
        a.put(null,null);

    }
}
class  Printer{
    protected  int  value = 0;

    public void print(){
        System.out.println(value);
    }
}

class  FastPrinter extends  Printer{
    public  int value = 1;

    @Override
    public void print(){
        System.out.println(value);
    }
}
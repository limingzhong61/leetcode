package exam.old.huawei.t1;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();
        while (in.hasNextInt()) {
            long x = in.nextInt();
            //int x = Integer.parseInt(s);
            boolean remove = true;
            while (remove) {
                remove = false;
                long sum = 0;
                //System.out.println(list.toString());
                for (int i = list.size() - 1; i >= 0; i--) {
                    sum += list.get(i);
                    if (sum == x) {
                        list.set(i, x * 2);
                        for (int j = list.size() - 1; j >= i; j--) {
                            list.remove(j);
                        }
                        remove = true;
                        x = x * 2;
                        break;
                    }
                }
            }
            list.add(x);
        }
        for (int i = list.size() - 1; i >= 1; i--) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.printf("%d", list.get(0));
    }
}

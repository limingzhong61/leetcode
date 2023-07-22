package test;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-04-22 13:39
 */
public class Test {
    public static void main(String[] args) {
        int x = Math.floor(Math.sqrt(i));
        System.out.println(f());
    }

    private static int f() {
        int i;
        try {
            i = 1;
            return i;
        }catch (RuntimeException e){
            i = 2;
        }finally {
            i = 3;
            return 3;
        }
        //return i;
    }

    Test() {
    }

    Test(String a) {
        this();
    }
}

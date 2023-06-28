package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: limingzhong
 * @create: 2023-06-28 17:19
 */
//@Se
public class SyncTest {
    synchronized void a(){
        System.out.println("a");
    }

    synchronized static void b(){
        System.out.println("b");
    }

    synchronized void c(){
        synchronized (this) {
            System.out.println("c");
        }
    }

    synchronized void d(){
        synchronized (SyncTest.class){
            System.out.println("d");
        }
    }

    public static void main(String[] args) throws IOException {
        SyncTest syncTest = new SyncTest();
        new Thread(()->{
            //log.info
            syncTest.a();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            SyncTest.b();
        }).start();

        //new Thread(()->{
        //    syncTest.c();
        //}).start();
        //
        //new Thread(()->{
        //    syncTest.d();
        //}).start();


        System.out.println("--------");
        System.in.read();
    }
}

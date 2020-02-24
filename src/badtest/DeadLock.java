package badtest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/20 13:13
 */
public class DeadLock {

    private static final String A="A";
    private static final String B="B";

    public void deadLock(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    System.out.println("A got");
                    try {
                        Thread.sleep(200);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("I get B");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("B got");
                    try {
                        Thread.sleep(200);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (A){
                        System.out.println("I get A");
                    }
                }
            }
        }).start();
    }
    public static void main(String[] args){
        new DeadLock().deadLock();
    }
}
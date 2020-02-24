package badtest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/20 15:17
 */
public class ThreadPool {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        i.compareAndSet(1,5);
        System.out.println(i);
    }
}

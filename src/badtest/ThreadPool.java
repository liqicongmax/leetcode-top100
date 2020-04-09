package badtest;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liqicong@myhexin.com
 * @date 2020/2/20 15:17
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(3,8,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

    }


    public void doSomething(){

    }
}

package cn.hagsyn.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
    private static ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(10);
    }
    public static void main(String[] args) {
        Future future = executorService.submit(new TestCallable());
        Object ret = null;
        try {
            ret = future.get();
        } catch (InterruptedException e) {
            System.out.println("11"+e.getMessage());
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("22"+e.getMessage());
            e.printStackTrace();
        }
        System.out.println(ret);
    }
}

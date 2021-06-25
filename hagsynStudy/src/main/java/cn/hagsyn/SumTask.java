package cn.hagsyn;

import cn.hagsyn.task.TaskOne;
import cn.hagsyn.task.TaskTwo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description
 * @Auther Hagsyn
 * @Date 2020/12/28 14:00
 */
public class SumTask {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long beginTime = System.currentTimeMillis();
        System.out.println(beginTime.getClass());
        //接口耗时：20210ms
        Map<Object, Object> retObj= getSum1();
        //接口耗时：10118ms
        //Map<Object, Object> retObj= getSum2();
        long endTime = System.currentTimeMillis();
        System.out.println("接口耗时："+ (endTime-beginTime) + "ms");
        retObj.forEach((k,v) -> {
            System.out.println("键:"+k+"------值:"+v);
        });
    }

    /**
     * 分开查询
     * @return
     */
    public static Map<Object, Object> getSum1 () {
        Map<Object, Object> retObj = new HashMap<Object, Object>();
        retObj.putAll(new TaskOne().exec());
        retObj.putAll(new TaskTwo().exec());
        return retObj;
    }

    /**
     * 使用多线程，同时进行
     * @return
     */
    public static Map<Object, Object> getSum2 () throws ExecutionException, InterruptedException {
        Map<Object, Object> retObj = new HashMap<Object, Object>();
        Future<Map<Object, Object>> taskOne = executorService.submit(() ->
             new TaskOne().exec()
        );
        Future<Map<Object, Object>> taskTwo = executorService.submit(() -> new TaskTwo().exec());
        retObj.putAll(taskOne.get());
        retObj.putAll(taskTwo.get());
        return retObj;
    }


}

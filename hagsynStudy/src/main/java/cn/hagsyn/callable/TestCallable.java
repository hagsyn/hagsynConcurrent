package cn.hagsyn.callable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<Map> {
    @Override
    public Map call() throws Exception {
        System.out.println("====我进来了=======");
        Map map = new HashMap();
        map.put("a","进来了");
        throw new RuntimeException("wolaile");
//        return map;
    }
}

package cn.hagsyn.task;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Auther Hagsyn
 * @Date 2020/12/28 13:52
 */
public class TaskOne implements Task{

    @Override
    public Map<Object, Object> exec() {
        Map<Object,Object> retMap = new HashMap<Object, Object>();
        for (int i=1;i<=10;i++) {
            retMap.put(i,this.getClass().getName()+"-"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return retMap;
    }
}

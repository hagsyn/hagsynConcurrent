package cn.hagsyn.controller;

import cn.hagsyn.config.HagsynServerConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Hagsyn
 * @date 2022/2/9
 */
@RestController
@RequestMapping("/configs")
public class ThreadDynamicController {

    @Resource
    private ThreadPoolExecutor dynamicThreadPool;

    @Resource
    private HagsynServerConfiguration configuration;

    @GetMapping
    public void configs() {
        System.out.println(dynamicThreadPool.hashCode());
        System.out.println("核心线程数：" + dynamicThreadPool.getCorePoolSize());
        System.out.println("最大线程数：" + dynamicThreadPool.getMaximumPoolSize());
    }

    @PostMapping
    public void setConfigs(Integer coreSize, Integer maxPoolSize) {
        dynamicThreadPool.setCorePoolSize(coreSize);
        dynamicThreadPool.setMaximumPoolSize(maxPoolSize);

    }
}

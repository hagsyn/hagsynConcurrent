package cn.hagsyn.config;

import cn.hippo4j.starter.core.DynamicThreadPool;
import cn.hippo4j.starter.toolkit.thread.ResizableCapacityLinkedBlockIngQueue;
import cn.hippo4j.starter.toolkit.thread.ThreadPoolBuilder;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Hagsyn
 * @date 2022/2/9
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 创建线程池时建议填充实际的参数。如果在连接 Hippo4J Server 端失败时，会使用填充配置创建线程池
     *
     * @return
     */
//    @Bean
//    @DynamicThreadPool
//    public ThreadPoolExecutor dynamicThreadPoolExecutor() {
//        String threadPoolId = "message-produce";
//        ThreadPoolExecutor dynamicExecutor = ThreadPoolBuilder.builder()
//                .threadFactory(threadPoolId)
//                .threadPoolId(threadPoolId)
//                .corePoolSize(5)
//                .maxPoolNum(10)
//                .workQueue(new ResizableCapacityLinkedBlockIngQueue(1024))
//                .rejected(new ThreadPoolExecutor.AbortPolicy())
//                .keepAliveTime(6000, TimeUnit.MILLISECONDS)
//                .dynamicPool()
//                .build();
//        return dynamicExecutor;
//    }

    /**
     * Spring 针对 JDK 线程池提供了增强版的 ThreadPoolTaskExecutor，Hippo4J 对此进行了适配
     * @return
     */
    @Bean
    @DynamicThreadPool
    public ThreadPoolExecutor dynamicThreadPoolExecutor() {
        String threadPoolId = "hagsyn-message-produce";
        ThreadPoolExecutor dynamicExecutor = ThreadPoolBuilder.builder()
                .threadFactory(threadPoolId)
                .threadPoolId(threadPoolId)
                .corePoolSize(5)
                .maxPoolNum(10)
                .workQueue(new ResizableCapacityLinkedBlockIngQueue(1024))
                .rejected(new ThreadPoolExecutor.AbortPolicy())
                .keepAliveTime(6000, TimeUnit.MILLISECONDS)
                // 等待终止毫秒
                .awaitTerminationMillis(5000)
                // 线程任务装饰器
                .taskDecorator((task) -> {
                    String placeholderVal = MDC.get("xxx");
                    return () -> {
                        try {
                            MDC.put("xxx", placeholderVal);
                            task.run();
                        } finally {
                            MDC.clear();
                        }
                    };
                })
                .dynamicPool()
                .build();
        return dynamicExecutor;
    }

}

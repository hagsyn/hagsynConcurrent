package cn.hagsyn;

import cn.hippo4j.starter.enable.EnableDynamicThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hagsyn
 * @date 2022/2/8
 */
@SpringBootApplication
@EnableDynamicThreadPool
public class Hippo4JApplication {
    public static void main(String[] args) {
        SpringApplication.run(Hippo4JApplication.class, args);
    }
}

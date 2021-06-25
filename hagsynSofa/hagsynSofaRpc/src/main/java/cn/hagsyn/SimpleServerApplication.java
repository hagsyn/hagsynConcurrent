package cn.hagsyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description
 * @Auther Hagsyn
 * @Date 2021/3/30 14:03
 */
@ImportResource({ "classpath:simple-server-example.xml" })
@SpringBootApplication
public class SimpleServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleServerApplication.class, args);
    }
}

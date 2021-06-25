package cn.hagsyn;

import cn.hagsyn.service.HelloHagsynService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description
 * @Auther Hagsyn
 * @Date 2021/3/30 15:54
 */
@ImportResource({ "classpath:simple-client-example.xml" })
@SpringBootApplication
public class SimpleClientApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication springApplication = new SpringApplication(SimpleClientApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);

        HelloHagsynService jvmHelloHagsynService = (HelloHagsynService) applicationContext.getBean("jvmHelloSyncServiceReference");


//        HelloHagsynService boltHelloHagsynService = (HelloHagsynService) applicationContext.getBean("boltHelloHagsynServiceReference");
//        HelloHagsynService restHelloHagsynService = (HelloHagsynService) applicationContext.getBean("restHelloHagsynServiceReference");
        HelloHagsynService dubboHelloHagsynService = (HelloHagsynService) applicationContext.getBean("dubboHelloHagsynServiceReference");

//        System.out.println("Bolt result:" + boltHelloHagsynService.sayHello("bolt"));
//        System.out.println("Rest result:" + restHelloHagsynService.sayHello("rest"));
        System.out.println("Dubbo result:" + dubboHelloHagsynService.sayHello("dubbo"));
        System.out.println("Jvm result:" + jvmHelloHagsynService.sayHello("jvm"));

    }
}
package cn.hagsyn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author Hagsyn
 * @date 2022/2/9
 */
@Configuration
@ConfigurationProperties(prefix = "hagsyn.server")
public class HagsynServerConfiguration {

    private Map<String, HagsynServer> user;

    public Map<String, HagsynServer> getUser() {
        return user;
    }

    public void setUser(Map<String, HagsynServer> user) {
        this.user = user;
    }

    private static class HagsynServer {

        private int name;

        private int age;

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

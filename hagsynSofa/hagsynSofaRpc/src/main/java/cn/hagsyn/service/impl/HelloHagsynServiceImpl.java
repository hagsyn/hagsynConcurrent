package cn.hagsyn.service.impl;

import cn.hagsyn.service.HelloHagsynService;

/**
 * @Description
 * @Auther Hagsyn
 * @Date 2021/3/30 15:46
 */
public class HelloHagsynServiceImpl implements HelloHagsynService {
    @Override
    public String sayHello(String name) {
        return name;
    }
}

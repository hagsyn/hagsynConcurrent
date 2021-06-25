package cn.hagsyn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Auther Hagsyn
 * @Date 2021/3/29 16:26
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/get")
    public String getConn(String num) {
       return "接收到了："+num;
    }
}

package com.test.controller;

import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author earthchen
 * @date 2021/8/17
 **/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @DubboReference
    private MyService myServiceStub;

    @GetMapping
    public Object test() {
        log.info("------------test");
        myServiceStub.sayHello(HelloRequest.newBuilder().build());
        return "ok";
    }
}

package com.test.controller;

import com.earthchen.rpc.lib.HelloReply;
import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class DemoConsumerControllerTest {

    @DubboReference
    private MyService myServiceStub;

    @org.junit.jupiter.api.Test
    public void sayHello() {
        try {
            HelloReply helloReply = myServiceStub.sayHello(HelloRequest.newBuilder().setName("ssss").build());
            System.out.println(helloReply);
        } catch (Exception e) {
            LocalDateTime now = LocalDateTime.now();
            log.error("", e);
        }
    }
}
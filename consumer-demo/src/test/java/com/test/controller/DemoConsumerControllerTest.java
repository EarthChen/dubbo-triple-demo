package com.test.controller;

import com.earthchen.rpc.lib.HelloReply;
import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoConsumerControllerTest {

    @DubboReference
    private MyService myServiceStub;

    @org.junit.jupiter.api.Test
    public void sayHello() {
        HelloReply helloReply = myServiceStub.sayHello(HelloRequest.newBuilder().setName("ssss").build());
        System.out.println(helloReply);
    }
}
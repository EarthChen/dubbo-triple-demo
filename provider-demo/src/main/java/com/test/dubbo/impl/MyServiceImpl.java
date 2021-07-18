package com.test.dubbo.impl;

import com.earthchen.rpc.lib.HelloReply;
import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;

/**
 * @author earthchen
 * @date 2021/6/22
 **/
@DubboService
public class MyServiceImpl implements MyService {

    @Override
    public HelloReply sayHello(HelloRequest helloRequest) {
        System.out.println("Executing thread is " + Thread.currentThread().getName());
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + helloRequest).build();
        return reply;
    }

    @Override
    public CompletableFuture<HelloReply> sayHelloAsync(HelloRequest helloRequest) {
        return null;
    }

}

package com.test.controller;

import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author earthchen
 * @date 2021/3/11
 **/
@RestController
public class DemoConsumerController {

    // @DubboReference
    // private IHelloService demoService;

    // @DubboReference
    // private MyService myService;

    @DubboReference
    private MyService myServiceStub;

    //
    // private ExecutorService executorService = Executors.newFixedThreadPool(4);
    //
    //
    // @RequestMapping("/sayHello/{name}")
    // public String sayHello(@PathVariable String name) {
    //     long start = System.currentTimeMillis();
    //     long end = System.currentTimeMillis();
    //     return demoService.helloGrpc(HelloRequest.newBuilder().setName("sssss").build()).getMessage() + (end - start);
    // }

    @RequestMapping("/test")
    public String test() {
        return myServiceStub.sayHello(HelloRequest.newBuilder().setName("set").build()).getMessage();
        // return myService.sayHello(HelloRequest.newBuilder().setName("sssss").build()).getMessage();
    }
}

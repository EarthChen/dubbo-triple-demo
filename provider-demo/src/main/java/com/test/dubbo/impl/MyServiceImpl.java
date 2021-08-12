package com.test.dubbo.impl;

import com.earthchen.rpc.lib.HelloReply;
import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyService;
import com.test.exception.DubboBizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;

/**
 * @author earthchen
 * @date 2021/6/22
 **/
@DubboService
@Slf4j
public class MyServiceImpl implements MyService {

    @Override
    public HelloReply sayHello(HelloRequest helloRequest) {
        log.error("test runtimeException helloRequest={}", helloRequest);
        throw new DubboBizException(1111, "test");
    }

    @Override
    public CompletableFuture<HelloReply> sayHelloAsync(HelloRequest helloRequest) {
        return null;
    }

}

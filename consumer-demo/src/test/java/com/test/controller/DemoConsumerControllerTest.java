package com.test.controller;

import com.earthchen.rpc.lib.HelloReply;
import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyService;
import io.grpc.health.v1.Health;
import io.grpc.health.v1.HealthCheckRequest;
import io.grpc.health.v1.HealthCheckResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class DemoConsumerControllerTest {

    @DubboReference
    private MyService myServiceStub;

    @DubboReference
    private Health health;

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


    @SneakyThrows
    @Test
    public void testServerStream() {
        health.watch(HealthCheckRequest.newBuilder().setService("").build(), new StreamObserver<HealthCheckResponse>() {

            @Override
            public void onNext(HealthCheckResponse data) {
                System.out.println("-------------");
                System.out.println(data);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("---end");
            }
        });
        System.in.read();
    }
}
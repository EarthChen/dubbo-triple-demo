package com.test.grpc;

import com.earthchen.rpc.lib.HelloReply;
import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HelloClientServiceTest {

    @GrpcClient("myService")
    private MyServiceGrpc.MyServiceBlockingStub myServiceBlockingStub;

    @Test
    public void testSayHello() {
        HelloRequest request = HelloRequest.newBuilder()
                .setName("testSayHello")
                .build();
        HelloReply reply = myServiceBlockingStub.sayHello(request);
        System.out.println("----------" + reply);
    }

}
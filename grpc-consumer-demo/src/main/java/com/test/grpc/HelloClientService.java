package com.test.grpc;

import com.earthchen.rpc.lib.HelloRequest;
import com.earthchen.rpc.lib.MyServiceGrpc;
import lombok.SneakyThrows;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author earthchen
 * @date 2019/12/23
 **/
@Service
public class HelloClientService {

    @GrpcClient("IMyService")
    private MyServiceGrpc.MyServiceBlockingStub myServiceBlockingStub;

    @SneakyThrows
    public String getReply(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return myServiceBlockingStub.sayHello(request).getMessage();
    }

}

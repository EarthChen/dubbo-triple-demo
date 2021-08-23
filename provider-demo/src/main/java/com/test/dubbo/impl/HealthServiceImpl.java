package com.test.dubbo.impl;

import io.grpc.health.v1.Health;
import io.grpc.health.v1.HealthCheckRequest;
import io.grpc.health.v1.HealthCheckResponse;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;

/**
 * @author earthchen
 * @date 2021/8/22
 **/
@DubboService
public class HealthServiceImpl implements Health {
    @Override
    public HealthCheckResponse check(HealthCheckRequest healthCheckRequest) {
        return null;
    }

    @Override
    public CompletableFuture<HealthCheckResponse> checkAsync(HealthCheckRequest healthCheckRequest) {
        return null;
    }

    @Override
    public void watch(HealthCheckRequest healthCheckRequest, StreamObserver<HealthCheckResponse> streamObserver) {
        System.out.println("---------watch----------x");
        System.out.println(healthCheckRequest);
        for (int i = 0; i < 10; i++) {
            streamObserver.onNext(HealthCheckResponse.newBuilder().setStatus(HealthCheckResponse.ServingStatus.NOT_SERVING).build());
        }
        streamObserver.onCompleted();
    }

    @Override
    public StreamObserver<HealthCheckRequest> watch2(StreamObserver<HealthCheckResponse> streamObserver) {
        return null;
    }
}

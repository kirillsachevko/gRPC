package org.javadv.service;

import io.grpc.stub.StreamObserver;
import org.grpc.service.Service;
import org.grpc.service.SimpleServiceGrpc;

public class SimpleServiceImpl extends SimpleServiceGrpc.SimpleServiceImplBase {
    private static final String PONG = " Pong";
    private static final String GREETING = "Greeting";

    @Override
    public void process(Service.SimpleRequest request, StreamObserver<Service.SimpleResponse> responseObserver) {
        System.out.println(request);

        Service.SimpleResponse response = Service.SimpleResponse.newBuilder()
                .setGreeting(GREETING)
                .setPong(PONG)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

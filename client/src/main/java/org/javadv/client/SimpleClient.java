package org.javadv.client;

import io.grpc.Channel;
import org.grpc.service.Service;
import org.grpc.service.SimpleServiceGrpc;

public class SimpleClient {
    private static final String PING = "Ping";
    private final SimpleServiceGrpc.SimpleServiceBlockingStub blockingStub;

    public SimpleClient(Channel channel) {
        blockingStub = SimpleServiceGrpc.newBlockingStub(channel);
    }

    public void sendRequest() {
        Service.SimpleRequest request = Service.SimpleRequest.newBuilder()
                .setPing(PING)
                .build();

        Service.SimpleResponse response = blockingStub.process(request);

        System.out.printf(response.getGreeting());
        System.out.println(response.getPong());
    }
}

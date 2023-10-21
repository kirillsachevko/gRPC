package org.javadv;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.javadv.client.SimpleClient;

public class ClientApp {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8089")
                .usePlaintext()
                .build();

        SimpleClient client = new SimpleClient(channel);
        client.sendRequest();
    }
}
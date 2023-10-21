package org.javadv

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.javadv.client.SimpleClient


fun main() {
    val channel: ManagedChannel = ManagedChannelBuilder.forTarget("localhost:8089")
            .usePlaintext()
            .build()

    val client = SimpleClient(channel)
    client.sendRequest()
}

package org.javadv.client

import io.grpc.ManagedChannel
import org.grpc.service.Service
import org.grpc.service.SimpleServiceGrpc

class SimpleClient(channel: ManagedChannel) {
    private val blockingStub: SimpleServiceGrpc.SimpleServiceBlockingStub = SimpleServiceGrpc.newBlockingStub(channel)

    fun sendRequest() {
        val request = Service.SimpleRequest.newBuilder()
                .setPing(PING)
                .build()

        val response = blockingStub.process(request)

        println(response.greeting)
        println(response.pong)
    }

    companion object {
        private const val PING = "Ping"
    }
}
package org.javadv.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.javadv.service.SimpleServiceImpl;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleServer {

    public static final Logger LOGGER = Logger.getLogger(SimpleServer.class.getName());
    private static final int PORT = 8089;
    private Server server;

    public void runServer() {
        try {
            server = ServerBuilder.forPort(PORT)
                    .addService(new SimpleServiceImpl())
                    .build()
                    .start();

            LOGGER.log(Level.SEVERE, "server started on: " + PORT);

            server.awaitTermination();

            Runtime.getRuntime().addShutdownHook(new Thread(SimpleServer.this::stopServer));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "starting server interrupted");
        }
    }

    public void stopServer() {
        if (server != null) {
            try {
                server.shutdown().awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "stopping server interrupted");
            }
        }
    }
}

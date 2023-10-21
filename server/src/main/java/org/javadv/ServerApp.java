package org.javadv;

import org.javadv.server.SimpleServer;

public class ServerApp {
    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        server.runServer();
    }
}
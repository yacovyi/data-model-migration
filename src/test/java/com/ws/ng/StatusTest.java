package com.ws.ng;

import static org.junit.jupiter.api.Assertions.*;

import com.ws.ng.providers.RestClientFactory;
import com.ws.ng.resources.Status;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;


public class StatusTest {

    private HttpServer server;
    private WebTarget target;

    @BeforeEach
    public void setUp() {
        server = Main.startServer();
        Client c = RestClientFactory.newClient();
        target = c.target(Main.BASE_URI);
    }

    @AfterEach
    public void tearDown() {
        server.shutdownNow();
    }

    @Test
    public void shouldReceiveIdleStatus() {
        Status status = target.path("status").request().get(Status.class);
        assertEquals("idle", status.getStatus());
    }
}
package com.ws.ng;

import com.ws.ng.configuration.Config;
import com.ws.ng.resources.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("status")
public class StatusHandler {
    static final Logger logger = LogManager.getLogger(StatusHandler.class.getName());

    private Config config;

    private StatusService statusService;

    @Inject
    public StatusHandler(Config config, StatusService statusService) {
        this.config = config;
        this.statusService = statusService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Status statusInformation() {
        logger.trace("Status was requested");
        System.out.println(config.kafkaBrokers());
        return new Status().setStatus("idle");
    }

    @POST
    public Response produceAMessage() {
        statusService.produceMessageTokafka("test1");
        return Response.ok().build();
    }
}

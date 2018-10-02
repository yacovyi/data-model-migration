package com.ws.ng;

import com.ws.ng.resources.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("status")
public class StatusHandler {
    static final Logger logger = LogManager.getLogger(StatusHandler.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Status statusInformation() {
        logger.trace("Status was requested");
        return new Status().setStatus("idle");
    }
}

package com.ws.ng;

import com.ws.ng.configuration.Config;
import com.ws.ng.configuration.ConfigurationProvider;
import com.ws.ng.resources.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@Path("status")
public class StatusHandler {
    static final Logger logger = LogManager.getLogger(StatusHandler.class.getName());

    @Inject
    private ConfigurationProvider config;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Status statusInformation() {
        logger.trace("Status was requested");
        System.out.println(config.get().kafkaBrokers());
        return new Status().setStatus("idle");
    }
}

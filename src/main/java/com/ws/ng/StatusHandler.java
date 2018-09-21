package com.ws.ng;

import com.ws.ng.resources.Status;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("status")
public class StatusHandler {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Status statusInformation() {
        return new Status().setStatus("idle");
    }
}

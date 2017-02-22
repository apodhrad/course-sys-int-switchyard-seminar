package com.redhat.brq.integration.switchyard.accounting;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.redhat.brq.integration.switchyard.models.Order;

@Path("/accounting")
public interface RefServiceResource {

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    String account(Order order);
}

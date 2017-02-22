package com.example.switchyard.switchyard_seminar_final.accounting;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import com.example.switchyard.switchyard_seminar_final.model.Order;

@Path("/accounting")
public interface AccountingServiceResource {
    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    @BadgerFish
    AccountResponse account(Order order);
}

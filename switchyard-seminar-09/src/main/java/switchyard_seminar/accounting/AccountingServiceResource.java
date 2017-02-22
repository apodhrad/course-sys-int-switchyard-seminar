package switchyard_seminar.accounting;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import switchyard_seminar.model.Order;

@Path("/accounting")
public interface AccountingServiceResource {
    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    @BadgerFish
    AccountResponse account(Order order);
}

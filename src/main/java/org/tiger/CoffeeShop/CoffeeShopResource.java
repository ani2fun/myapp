package org.tiger.CoffeeShop;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by aniket on 3/2/16.
 */

@Path("/coffeeshop")
@Produces(MediaType.APPLICATION_JSON)
public class CoffeeShopResource {

   /* private DB database;

    public CoffeeShopResource(final DB database) {
        this.database = database;
    }
*/

    private Datastore datastore;

    public CoffeeShopResource(final MongoClient mongoClient) {
        this.datastore = new Morphia().createDatastore(mongoClient,"Cafelito");
    }

    @GET
    @Path("/dummy")
    public Response getDummy(){
        return Response.ok("Dummy get").build();
    }

    @POST()
    @Path("order")
    @Consumes(MediaType.APPLICATION_JSON)
   // public Response saveOrder(@PathParam("id") long coffeeShopId, Order order) {
    public Response saveOrder( Order order) {
            //order.setCoffeeShopId(coffeeShopId);
            datastore.save(order);

        return Response.created(URI.create(order.getId())).entity(order).build();
    }


}

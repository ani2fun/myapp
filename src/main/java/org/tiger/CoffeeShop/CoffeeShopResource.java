package org.tiger.CoffeeShop;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

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

    @POST
    @Path("{id}/order/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doSomeAction(@PathParam("id") long coffeeShopId, Order order) {
        /*order.setCoffeeShopId(coffeeShopId);
        DBCollection collectionOrders = database.getCollection("orders");
        JacksonDBCollection<Order, String> collection = JacksonDBCollection.wrap(collectionOrders, Order.class, String.class);
        WriteResult<Order,String>  writeResult = collection.insert(order);

        if(writeResult ==null){
            return Response.serverError().build();
        }

        order.setId(writeResult.getSavedId());*/




        return Response.created(URI.create(order.getId())).entity(order).build();
    }


}

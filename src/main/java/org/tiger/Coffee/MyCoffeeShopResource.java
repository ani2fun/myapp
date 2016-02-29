package org.tiger.Coffee;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


@Path("/mycoffeeshop")
@Produces(MediaType.APPLICATION_JSON)
public class MyCoffeeShopResource {

    private Datastore datastore;

    public MyCoffeeShopResource(final MongoClient mongoClient) {

        datastore  = new Morphia().createDatastore(mongoClient,"AniketCoffeeShop");
    }

    @Path("myorder")
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMyOrder(Order order){

        datastore.save(order);
       return Response.created(URI.create(order.getId())).entity(order).build();
    }


    @Path("dummy")
    @GET
    public CoffeeShop getDummy() {
        return new CoffeeShop("A dummy coffee shop");
    }
}

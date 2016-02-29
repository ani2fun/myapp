package org.tiger.Coffee;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


@Path("/mycoffeeshop")
@Produces(MediaType.APPLICATION_JSON)
public class MyCoffeeShopResource {
    private final Datastore datastore;

    public MyCoffeeShopResource(final MongoClient mongoClient) {
        datastore = new Morphia().createDatastore(mongoClient, "AniketCoffeeShop");
    }

    @Path("order")
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response giveMeCoffee(Order order){
        return Response.created(URI.create(order.getId())).entity(order).build();
    }


    @Path("dummy")
    @GET
    public CoffeeShop getDummy() {
        return new CoffeeShop("A dummy coffee shop");
    }

}
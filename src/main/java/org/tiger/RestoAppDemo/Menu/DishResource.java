package org.tiger.RestoAppDemo.Menu;

import com.mongodb.MongoClient;
import com.sun.org.apache.regexp.internal.RE;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * Created by aniket on 3/4/16.
 */

@Path("/dishes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DishResource {

   private Datastore datastore;

    public DishResource(final MongoClient mongoClient, final String dbName) {
        this.datastore = new Morphia().createDatastore(mongoClient,dbName);
    }

    @GET
    @Path("/{id}")
    public Response getDish(@PathParam("id") String id) {


        Query userQuery = datastore.find(Dish.class, "id", id);
        Dish foundDish = (Dish) userQuery.get();

        return Response.ok().entity(foundDish).build();
    }

    @GET
    public Response getAllDishes() {

        Query<Dish> userQuery = datastore.createQuery(Dish.class);
        List<Dish> allDishes = userQuery.asList();

        return Response.ok().entity(allDishes).build();
    }


    // NOTE : Implement Admin module later to add Dishes... Currently 3 dishes are stored in database for testing

    @POST
    public Response addNewDish(Dish dish) {

        datastore.save(dish);
        return Response.created(URI.create(String.valueOf(dish.getObjectId()))).entity(dish).build();
    }

    @PUT
    @Path("/{id}")
    public Response addDishComment(@PathParam("id") String id, DishComment newComment) {

      /*  Query userQuery = datastore.find(Dish.class, "id", id);
        // Dish foundDish = (Dish) userQuery.get();

        UpdateOperations<Dish> ops;
        datastore.update(userQuery, datastore.createUpdateOperations(Dish.class).add("comments", newComment, false));
*/
        final Query<Dish> underPaidQuery = datastore.createQuery(Dish.class).filter("id =", id);
        final UpdateOperations<Dish> updateOperations = datastore.createUpdateOperations(Dish.class).add("comments", newComment, false);
        final UpdateResults results = datastore.update(underPaidQuery, updateOperations);

        return Response.ok(results).build();
    }


}

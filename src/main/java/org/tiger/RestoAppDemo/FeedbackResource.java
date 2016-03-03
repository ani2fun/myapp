package org.tiger.RestoAppDemo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by aniket on 3/2/16.
 */


@Path("/feedback")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedbackResource {

    private DB database;

    public FeedbackResource(DB database) {
        this.database = database;
    }

    /* @GET
    @Path("/dummy")
    public Response Feedback() {

        return Response.ok("Feedback resource working").build();
    }*/


    @POST
    @Path("/{id}")
    public Response saveFeedback(@PathParam("id") int id, Feedback feedback) {


        return null;
    }


}


// return "POST Feedback works";
        /*feedback.setId(id);
        DBCollection collectionFeedback = database.getCollection("feedback");
        JacksonDBCollection<Feedback, String> feedbackDBCollection = JacksonDBCollection.wrap(collectionFeedback, Feedback.class, String.class);
        WriteResult<Feedback, String> writeResult = feedbackDBCollection.insert(feedback);

        if(writeResult ==null){
            return Response.serverError().build();
        }

        //feedback.setId(writeResult.getSavedId());

        return Response.created(URI.create(String.valueOf(feedback.getId()))).entity(feedback).build();*/

   /* @POST
    @Path("{id}/order/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doSomeAction(@PathParam("id") long coffeeShopId, Order order) {
        order.setCoffeeShopId(coffeeShopId);
        DBCollection collectionOrders = database.getCollection("orders");
        JacksonDBCollection<Order, String> collection = JacksonDBCollection.wrap(collectionOrders, Order.class, String.class);
        WriteResult<Order,String>  writeResult = collection.insert(order);

        if(writeResult ==null){
            return Response.serverError().build();
        }

        order.setId(writeResult.getSavedId());

        return Response.created(URI.create(order.getId())).entity(order).build();
    }
*/
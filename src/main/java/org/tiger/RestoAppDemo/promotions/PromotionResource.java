package org.tiger.RestoAppDemo.promotions;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by aniket on 3/5/16.
 */

@Path("/promotions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PromotionResource {

    private Datastore datastore;

    public PromotionResource(final MongoClient mongoClient4) {

        this.datastore = new Morphia().createDatastore(mongoClient4,"restoDemo");

    }


    @GET
    @Path("/{id}")
    public Response getPromotions(@PathParam("id") String id){
        Query<Promotion> query = datastore.find(Promotion.class,"id",id);
        List<Promotion> promoList = query.asList();
        return Response.ok().entity(promoList).build();
    }

    @POST
    public Response addPromotion(Promotion promotion){

        datastore.save(promotion);
        return Response.ok().entity(promotion).build();
    }
}

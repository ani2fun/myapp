package org.tiger.RestoAppDemo.leadership;

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

@Path("/leadership")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LeadershipResource {

    private Datastore datastore;

    public LeadershipResource(final MongoClient mongoClient, final String dbName){

        this.datastore = new Morphia().createDatastore(mongoClient,dbName);
    }


    @GET
    public Response getLeaderInfo(){
        Query<Leadership> query = datastore.createQuery(Leadership.class);
        List<Leadership> leadershipList = query.asList();
        return Response.ok().entity(leadershipList).build();
    }

    @GET
    @Path("/{id}")
    public Response getOneLeader(@PathParam("id") String id){

        Query userQuery = datastore.find(Leadership.class, "id", id);
        Leadership leader = (Leadership) userQuery.get();
        return Response.ok().entity(leader).build();
    }

    @POST
    public Response addLeadership(Leadership leadership){

        datastore.save(leadership);
        return Response.ok().entity(leadership).build();
    }

}

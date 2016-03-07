package org.tiger.RestoAppDemo.Feedback;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.Data;
import java.net.URI;

/**
 * Created by aniket on 3/2/16.
 */


@Path("/feedback")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedbackResource {

    private Datastore datastore;

    public FeedbackResource(final MongoClient mongoClient, final String dbName) {

        this.datastore = new Morphia().createDatastore(mongoClient, dbName);

        /*


            Mongo m = new Mongo(mongolabUri);
            mongoDB = m.getDB(mongolabUri.getDatabase());
         if ((mongoClientURI.getUsername() != null) && (mongoClientURI.getPassword() != null)) {
            mongoDB.authenticate(mongoClientURI.getUsername(), mongoClientURI.getPassword());
        }
*/



    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveFeedback(Feedback feedback) {
        datastore.save(feedback);
        return Response.created(URI.create(feedback.getId())).entity(feedback).build();
    }



}


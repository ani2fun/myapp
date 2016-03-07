package org.tiger;

import com.mongodb.MongoClient;
import io.dropwizard.lifecycle.Managed;

/**
 * Created by aniket on 3/3/16.
 */
public class MongoClientManager implements Managed{
private final MongoClient mongoClient;

    public MongoClientManager(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

        mongoClient.close();

    }
}

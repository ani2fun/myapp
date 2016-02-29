package org.tiger;

import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.*;
import org.tiger.Coffee.CoffeeShopResource;
import org.tiger.Coffee.MongoClientManager;
import org.tiger.Coffee.MyCoffeeShopResource;


import java.net.UnknownHostException;

/**
 * Created by aniket on 2/22/16.
 */
public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(final Bootstrap<AppConfiguration> bootstrap) {

        //bootstrap.setName("Hello-world");
        AssetsBundle assetsBundle = new AssetsBundle("/html/","/");
        bootstrap.addBundle(assetsBundle);
    }


    @Override
    public void run(AppConfiguration c, Environment e) throws Exception {

        MongoClient mongoClient;


        mongoClient = new MongoClient();

        e.jersey().register(new MongoClientManager(mongoClient));
        e.jersey().register(new CoffeeShopResource(mongoClient));
        e.jersey().register(new MyCoffeeShopResource(mongoClient));




    }
}


   /* MongoURI mongolabUri = new MongoURI(System.getenv("MONGOLAB_URI") != null ? System.getenv("MONGOLAB_URI") : "mongodb://127.0.0.1:27017/hello2");
    Mongo m = new Mongo(mongolabUri);
mongoDB = m.getDB(mongolabUri.getDatabase());
        if ((mongolabUri.getUsername() != null) && (mongolabUri.getPassword() != null)) {
        mongoDB.authenticate(mongolabUri.getUsername(), mongolabUri.getPassword());
        }*/

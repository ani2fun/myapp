package org.tiger;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.*;
import org.tiger.CoffeeShop.CoffeeShopResource;
import org.tiger.RestoAppDemo.Feedback.FeedbackResource;
import org.tiger.RestoAppDemo.Menu.DishResource;
import org.tiger.RestoAppDemo.leadership.LeadershipResource;
import org.tiger.RestoAppDemo.promotions.PromotionResource;

import java.util.ArrayList;
import java.util.List;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(final Bootstrap<AppConfiguration> bootstrap) {

        AssetsBundle assetsBundle = new AssetsBundle("/html/", "/");
        bootstrap.addBundle(assetsBundle);
    }


    @Override
    public void run(final AppConfiguration configuration, final Environment environment) throws Exception {

        //MongoClientURI  mongoClientURI = new MongoClientURI(System.getenv("MONGOLAB_URI") != null ? System.getenv("MONGOLAB_URI") : "mongodb://127.0.0.1:27017/mydb");

        String MONGOLAB_URI = "mongodb://heroku_q29582ps:5cvfqqappp0q9p27ljvr5f9kjo@ds013908.mongolab.com:13908/heroku_q29582ps";

        MongoClientURI mongoClientURI = new MongoClientURI(MONGOLAB_URI);
        String dbName = mongoClientURI.getDatabase();
        String dbUsername = mongoClientURI.getUsername();
        String dbPassword = String.valueOf(mongoClientURI.getPassword());


        ServerAddress addr = new ServerAddress("ds013908.mongolab.com", 13908);
        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
        MongoCredential credential = MongoCredential.createCredential(dbUsername, dbName, dbPassword.toCharArray());
        credentialsList.add(credential);

        MongoClient mongoClient = new MongoClient(addr, credentialsList);   // Add MongoLabURL for heroku deployment

        System.out.println("Connection Point:" + mongoClient.getConnectPoint());
        System.out.println("DataBase Name:" + dbName);
        //System.out.println("DB UserName: " + dbUsername);
        //System.out.println("DB Password: " + dbPassword);


        environment.lifecycle().manage(new MongoClientManager(mongoClient));

        // Jersey Resource Registration
        environment.jersey().register(new CoffeeShopResource(mongoClient, dbName));
        environment.jersey().register(new FeedbackResource(mongoClient, dbName));
        environment.jersey().register(new DishResource(mongoClient, dbName));   // it's inside Menu Package
        environment.jersey().register(new PromotionResource(mongoClient, dbName));
        environment.jersey().register(new LeadershipResource(mongoClient, dbName));


        environment.jersey().register(new TestResource());


    }
}


   /*

           MongoURI mongolabUri = new MongoURI(System.getenv("MONGOLAB_URI") != null ? System.getenv("MONGOLAB_URI") : "mongodb://127.0.0.1:27017/hello2");
            Mongo m = new Mongo(mongolabUri);
            mongoDB = m.getDB(mongolabUri.getDatabase());
         if ((mongoClientURI.getUsername() != null) && (mongoClientURI.getPassword() != null)) {
            mongoDB.authenticate(mongoClientURI.getUsername(), mongoClientURI.getPassword());
        }



        Morphia morphia = new Morphia();
ServerAddress addr = new ServerAddress("host", 27017);
List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
MongoCredential credentia = MongoCredential.createCredential(
    "username", "dbname", "password".toCharArray());
credentialsList.add(credentia);
MongoClient client = new MongoClient(addr, credentialsList);
datastore = morphia.createDatastore(client, "dbname");

*/


// TO get MONGOLAB_URI : aniket$:   heroku config | grep MONGOLAB_URI

//  aniket$:  mongo ds013908.mongolab.com:13908/heroku_q29582ps -u heroku_q29582ps -p 5cvfqqappp0q9p27ljvr5f9kjo
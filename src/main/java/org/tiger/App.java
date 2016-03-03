package org.tiger;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.*;
import org.skife.jdbi.v2.DBI;
import org.tiger.CoffeeShop.CoffeeShopResource;
import org.tiger.PhoneBookDemo.resources.ContactResource;
import org.tiger.RestoAppDemo.FeedbackResource;


/**
 * Created by aniket on 2/22/16.
 */
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

        //MongoClientURI mongoClientURI = new MongoClientURI(System.getenv("MONGOLAB_URI") != null ? System.getenv("MONGOLAB_URI") : "mongodb://127.0.0.1:27017/AniketCoffeeShop");
        //MongoClient mongoClient = new MongoClient(mongoClientURI);
       /* final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        // Add the resource to the environment
        environment.jersey().register(new ContactResource(jdbi));*/

        //MongoClient mongoClient = new MongoClient();
        //DB database = mongoClient.getDB("AniketCoffeeShop");
        //environment.jersey().register(new CoffeeShopResource(database));

        //MongoClient mongoClientResto = new MongoClient();
        //DB restoDemo = mongoClientResto.getDB("restoDemo");
        //environment.jersey().register(new FeedbackResource(restoDemo));

//        environment.jersey().register(new CoffeeShopResource());


    }
}


   /* MongoURI mongolabUri = new MongoURI(System.getenv("MONGOLAB_URI") != null ? System.getenv("MONGOLAB_URI") : "mongodb://127.0.0.1:27017/hello2");
    Mongo m = new Mongo(mongolabUri);
mongoDB = m.getDB(mongolabUri.getDatabase());
        if ((mongolabUri.getUsername() != null) && (mongolabUri.getPassword() != null)) {
        mongoDB.authenticate(mongolabUri.getUsername(), mongolabUri.getPassword());
        }*/


/*

db         :AniketCoffeeShop
collection : coffeeshop

{


        "_id" : ObjectId("56cc978f86c62e9802c07240"),
        "openStreetMapId" : "220916220",
        "location" : {
        "coordinates" : [
        10.403188,
        63.42825
        ],
        "type" : "Point"
        },
        "addr:city" : "Trondheim",
        "addr:country" : "NO",
        "addr:housenumber" : "3",
        "addr:postcode" : "7014",
        "addr:street" : "Nedre Bakklandet",
        "amenity" : "cafe",
        "cuisine" : "coffee_shop",
        "name" : "Dromedar Kaffebar",
        "opening_hours" : "Mo-Th 07:30-19:00; Fr 07:30-18:00; Sa 10:00-18:00; Su 10:30-18:00",
        "phone" : "+47 73 52 25 02",
        "website" : "http://www.dromedar.no"
        }
*/

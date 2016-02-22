package org.tiger;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.*;

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



    }
}

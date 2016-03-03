package org.tiger;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by aniket on 2/22/16.
 */
public class AppConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String assetsPath;

    public String getAssetsPath() {
        return assetsPath;
    }



    @JsonProperty
    private DataSourceFactory database = new
            DataSourceFactory();
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}

package org.tiger;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
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
}

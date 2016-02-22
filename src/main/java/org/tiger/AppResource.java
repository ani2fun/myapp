package org.tiger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by aniket on 2/22/16.
 */

@Path("/hello")
public class AppResource {

    @GET
    public String hello(){
        return "Hello from ";
    }
}

package org.tiger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by aniket on 3/7/16.
 */

@Path("/hello")
public class TestResource {

    @GET
    public Response helloMe(){

        return Response.ok("Hello Me !").build();
    }
}

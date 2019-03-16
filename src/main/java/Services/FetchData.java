package Services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fetchdata")
@Produces(MediaType.TEXT_HTML)
public class FetchData {

    public FetchData() {
    }

    @GET
    @Path("/data")
    public Response fetchData(@QueryParam("zoom") String zoom,
                              @QueryParam("lat") String lat,
                              @QueryParam("lng") String lng) {
        return Response.status(Response.Status.OK).entity("1").build();
        //BIG TODO
    }

}

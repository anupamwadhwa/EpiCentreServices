package Services;

import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/hospital")
@Produces(MediaType.TEXT_HTML)
public class HospitalLogin {

    public HospitalLogin() {
    }

    @GET
    @Path("/abc")
    public Response printHello(){
        return Response.status(Response.Status.OK).entity("hello").build();
    }

    @POST
    @Path("/hospitalLogin")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response checkCredentials(@FormDataParam("userID") String userID,
                                     @FormDataParam("password") String password) {
        Map userIDPassword = new HashMap<String, String>();
        userIDPassword.put("abc", "def");
        if (userIDPassword.containsKey(userID)) {
            String correctPassword = (String) userIDPassword.get(userID);
            if (correctPassword.equals(password)) {
                return Response.status(Response.Status.OK).entity("2").build();
            } else {
                return Response.status(Response.Status.OK).entity("1").build();
            }
        } else {
            return Response.status(Response.Status.OK).entity("0").build();
        }

    }
    //Result : 0 -- Wrong UserName
    //Result : 1 -- Correct UserName but Wrong Password
    //Result : 2 -- Correct UserName and Wrong Password
}
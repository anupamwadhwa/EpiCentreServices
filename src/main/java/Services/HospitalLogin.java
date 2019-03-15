package Services;

import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class HospitalLogin {

    public HospitalLogin() {
    }

    @POST
    @Path("/hospitalLogin")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response checkCredentials(@FormDataParam("userID") String userID,
                                     @FormDataParam("password") String password) {
        Map userIDPassword = new HashMap<String, String>();
        userIDPassword.put("abc","def");
        if (userIDPassword.containsKey(userID)) {
            String correctPassword = (String) userIDPassword.get(userID);
            if (correctPassword == password) {
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

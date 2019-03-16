package Services;

import Factories.LoginDetailsFactory;
import com.google.common.io.Files;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

@Path("/hospital")
@Produces(MediaType.TEXT_HTML)
public class HospitalLogin {

    public HospitalLogin() {
    }

    @GET
    @Path("/login")
    public Response printHello() throws IOException {
        File file = new File("HTMLFiles/login.html");
        BufferedReader bufferedReader = Files.newReader(file, Charset.defaultCharset());
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            stringBuilder.append(str);
        }
        str = stringBuilder.toString();
        return Response.status(Response.Status.OK).entity(str).build();
    }

    @POST
    @Path("/checkLogin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response checkCredentials(@FormParam("userID") String userID,
                                     @FormParam("password") String password) throws IOException {
        Map userIDPassword = LoginDetailsFactory.provideDetails();
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

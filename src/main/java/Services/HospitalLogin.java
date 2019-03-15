package Services;

import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class HospitalLogin {

    public HospitalLogin() {
    }

    @POST
    @Path("/hospitalLogin")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response checkCredentials(){

    }
}

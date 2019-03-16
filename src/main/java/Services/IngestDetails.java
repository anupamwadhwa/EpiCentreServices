package Services;

import com.opencsv.CSVWriter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;

@Path("/addDetails")
@Produces(MediaType.TEXT_HTML)
public class IngestDetails {

    public IngestDetails() {
    }

    @GET
    @Path("/hello")
    public Response printHello() {
        return Response.status(Response.Status.OK).entity("hello").build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addDetails(@FormParam("disease") String disease,
                               @FormParam("address") String address,
                               @FormParam("pincode") String pinCode) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter("data.csv", true));
        String[] record = new String[3];
        record[0] = disease;
        record[1] = address;
        record[2] = pinCode;
        csvWriter.writeNext(record);
        csvWriter.close();
        return Response.status(Response.Status.OK).entity("Added").build();
    }

}

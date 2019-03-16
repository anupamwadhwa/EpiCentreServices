package Services;

import MapsAPIs.ProvideRequiredPoints;
import Models.DataItem;
import com.google.common.io.Files;
import com.opencsv.CSVReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Path("/fetchdata")
@Produces(MediaType.APPLICATION_JSON)
public class FetchData {

    public FetchData() {
    }


    @GET
    @Path("/data")
    public Response fetchData(@QueryParam("minLat") String minLat,
                              @QueryParam("maxLat") String maxLat,
                              @QueryParam("minLag") String minLag,
                              @QueryParam("maxLag") String maxLag) throws IOException {
        List list = ProvideRequiredPoints.fetchDataInWindow(Double.valueOf(minLat), Double.valueOf(maxLat), Double.valueOf(minLag), Double.valueOf(maxLag));
        return Response.status(Response.Status.OK).entity(list).build();
    }

    @GET
    @Path("/alldata")
    public Response fetchData() throws IOException {
        File file = new File("cord.csv");
        BufferedReader bufferedReader = Files.newReader(file, Charset.defaultCharset());
        CSVReader csvReader = new CSVReader(bufferedReader);
        String[] nextRecord;
        ArrayList<DataItem> dataItems = new ArrayList<DataItem>();
        while ((nextRecord = csvReader.readNext()) != null) {
            DataItem dataItem = new DataItem();
            dataItem.setLat(nextRecord[1]);
            dataItem.setLng(nextRecord[2]);
            dataItem.setDisease(nextRecord[0]);
            dataItems.add(dataItem);
        }
        return Response.status(Response.Status.OK).entity(dataItems).build();
    }

}

package MapsAPIs;

import MapsAPIs.data.Coordinates;
import MapsAPIs.data.Response;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

public class Geocoder implements Serializable
{

    private static final long serialVersionUID = 1L;
    // Constants
    public static final String OUTPUT_CSV = "csv";
    public static final String OUTPUT_XML = "xml";
    public static final String OUTPUT_KML = "kml";
    public static final String OUTPUT_JSON = "json";

    public static final String KEY = "dzuweOKG1UvLSLKHRnUf9FRsasGjvwRG";
    private final String output = OUTPUT_CSV;

    public Geocoder()
    {
    }

    public Coordinates decode(JSONObject response) throws GeocoderException
    {

        Gson gson = new Gson();
        Response result = gson.fromJson(response.toString(),Response.class);
        return result.getResults().get(0).getLocations().get(0).getLatLng();

    }

    /**
     * builds the google geo-coding url
     *
     * @param address
     * @return
     */
    public String encode(final String address)
    {
        return "http://www.mapquestapi.com/geocoding/v1/address?key=" + KEY + "&location=" + address;
    }

    /**
     * @param address
     * @return
     * @throws IOException
     */
    public Coordinates geocode(String address) throws IOException
    {
        address = address.replaceAll("\\s","%20");
        InputStream is = invokeService(encode(address));
        if (is != null)
        {
            try
            {
                JSONObject content = getStringFromInputStream(is);
                System.out.println(content.toString());
                return decode(content);
            }
            finally
            {
                is.close();
            }
        }
        return null;

    }

    public static JSONObject getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject result= new JSONObject(sb.toString());

        return result;

    }

    /**
     * fetches the url content
     *
     * @param address
     * @return
     * @throws IOException
     */
    protected InputStream invokeService(final String address) throws IOException
    {
        URL url = new URL(address);
        return url.openStream();
    }

    /**
     * url-encode a value
     *
     * @param value
     * @return
     */
    private String urlEncode(final String value)
    {
        try
        {
            return URLEncoder.encode(value, "UTF-8");
        }
        catch (UnsupportedEncodingException ex)
        {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
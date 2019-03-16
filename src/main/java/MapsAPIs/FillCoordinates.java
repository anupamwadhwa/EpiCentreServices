package MapsAPIs;

import MapsAPIs.data.Coordinates;
import com.google.common.io.Files;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FillCoordinates {
    public static void main(String[] args) throws IOException {
        Geocoder geocoder = new Geocoder();
        Coordinates result = geocoder.geocode("4-D Villa, Khasa Kothi Circle, Station Rd, Kanti Nagar, Bani Park, Jaipur, Rajasthan 302001");
        File file = new File("data.csv");
        BufferedReader bufferedReader = Files.newReader(file, Charset.defaultCharset());
        CSVReader csvReader = new CSVReader(bufferedReader);
        File outputFile = new File("cord.csv");
        CSVWriter csvWriter = new CSVWriter(new FileWriter("cord.csv", true));
        String[] record = new String[3];
        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            Coordinates geocode = geocoder.geocode(nextRecord[2]);
            record[0] = nextRecord[0];
            record[1] = geocode.getLat();
            record[2] = geocode.getLng();
            csvWriter.writeNext(record);
        }
        csvWriter.close();
    }
}

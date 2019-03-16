package MapsAPIs;

import Models.DataItem;
import com.google.common.io.Files;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ProvideRequiredPoints {
    public static List fetchDataInWindow(double minLat, double maxLat, double minLag, double maxLag) throws IOException {
        File file = new File("cord.csv");
        BufferedReader bufferedReader = Files.newReader(file, Charset.defaultCharset());
        CSVReader csvReader = new CSVReader(bufferedReader);
        String[] nextRecord;
        ArrayList<DataItem> dataItems = new ArrayList<DataItem>();
        while ((nextRecord = csvReader.readNext()) != null) {
            Double lat = Double.valueOf(nextRecord[1]);
            Double lng = Double.valueOf(nextRecord[2]);
            if (lat > minLat && lat < maxLat && lng > minLag && lng < maxLag) {
                DataItem dataItem = new DataItem();
                dataItem.setLat(nextRecord[1]);
                dataItem.setLng(nextRecord[2]);
                dataItem.setDisease(nextRecord[0]);
                dataItems.add(dataItem);
            }
        }
        return dataItems;
    }
}

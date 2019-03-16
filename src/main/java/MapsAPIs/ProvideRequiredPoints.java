package MapsAPIs;

import Models.AreaDataItem;
import Models.DataItem;
import com.google.common.io.Files;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProvideRequiredPoints {

    private static List requiredArea(double minLat, double maxLat, double minLag, double maxLag, List<DataItem> dataItems) {
        Map<String, Double> xSum = new HashMap<String, Double>();
        Map<String, Double> ySum = new HashMap<String, Double>();
        Map<String, Integer> count = new HashMap<String, Integer>();
        Map<String, Double> radius = new HashMap<String, Double>();

        for (DataItem dataItem : dataItems) {
            String disease = dataItem.getDisease();
            if (!count.containsKey(disease)) {
                count.put(disease, 0);
                xSum.put(disease, 0.0);
                ySum.put(disease, 0.0);
                radius.put(disease, 0.0);
            }
            int i = count.get(disease) + 1;
            count.put(disease, i);
            double u = xSum.get(disease) + Double.valueOf(dataItem.getLng());
            xSum.put(disease, u);
            double v = ySum.get(disease) + Double.valueOf(dataItem.getLat());
            ySum.put(disease, v);
        }

        for (DataItem dataItem : dataItems) {
            String disease = dataItem.getDisease();
            Double Lng = Double.valueOf(dataItem.getLng());
            Double Lat = Double.valueOf(dataItem.getLat());
            double r = radius.get(disease);
            double xavg = xSum.get(disease) / count.get(disease);
            double yavg = ySum.get(disease) / count.get(disease);
            r += (xavg - Lng) * (xavg - Lng) + (yavg - Lat) * (yavg - Lat);
            radius.put(disease, r);
        }

        Map<String, Double> radiusAvg = new HashMap<String, Double>();

        for (String disease : radius.keySet()) {
            radiusAvg.put(disease, radius.get(disease) / count.get(disease));
        }

        ArrayList<AreaDataItem> areaDataItems = new ArrayList<AreaDataItem>();

        for (String disease : radiusAvg.keySet()) {
            double xavg = xSum.get(disease) / count.get(disease);
            double yavg = ySum.get(disease) / count.get(disease);
            double radii = Math.sqrt(radiusAvg.get(disease));
            AreaDataItem areaDataItem = new AreaDataItem(disease, Double.toString(yavg), Double.toString(xavg), Double.toString(radii));
            areaDataItems.add(areaDataItem);
        }

        return areaDataItems;
    }

    public static List fetchAreaDataInWindow(double minLat, double maxLat, double minLag, double maxLag) throws IOException {
        ArrayList<DataItem> dataItems = getDataItems(minLat, maxLat, minLag, maxLag);
        return requiredArea(minLat, maxLat, minLag, maxLag, dataItems);
    }

    public static List fetchDataInWindow(double minLat, double maxLat, double minLag, double maxLag) throws IOException {
        return getDataItems(minLat, maxLat, minLag, maxLag);
    }


    private static ArrayList<DataItem> getDataItems(double minLat, double maxLat, double minLag, double maxLag) throws IOException {
        File file = new File("finaldata.csv");
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

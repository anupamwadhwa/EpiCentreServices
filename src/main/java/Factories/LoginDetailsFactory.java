package Factories;

import com.google.common.io.Files;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class LoginDetailsFactory {

    private static Map userIDPassword;

    public static Map provideDetails() throws IOException {
        if (userIDPassword == null) {
            File file = new File("hospital.csv");
            BufferedReader bufferedReader = Files.newReader(file, Charset.defaultCharset());
            CSVReader csvReader = new CSVReader(bufferedReader);
            String[] nextRecord;
            userIDPassword = new HashMap<String, String>();
            while ((nextRecord = csvReader.readNext()) != null) {
                userIDPassword.put(nextRecord[0], nextRecord[1]);
            }
            return userIDPassword;
        } else return userIDPassword;
    }
}


package Models;

import MapsAPIs.data.Coordinates;

public class DataItem extends Coordinates {
    String disease;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "disease='" + disease + '\'' +
                '}';
    }

}

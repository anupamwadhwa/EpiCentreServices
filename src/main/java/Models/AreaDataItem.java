package Models;

public class AreaDataItem {
    private String disease;
    private String lat;
    private String lng;
    private String radius;

    public AreaDataItem(String disease, String lat, String lng, String radius) {
        this.disease = disease;
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "AreaDataItem{" +
                "disease='" + disease + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}

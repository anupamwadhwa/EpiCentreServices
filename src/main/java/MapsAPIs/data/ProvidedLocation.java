package MapsAPIs.data;

public class ProvidedLocation {
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ProvidedLocation{" +
                "location='" + location + '\'' +
                '}';
    }
}

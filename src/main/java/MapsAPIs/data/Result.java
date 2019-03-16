package MapsAPIs.data;

import java.util.List;

public class Result {
    private ProvidedLocation providedLocation;
    private List<Location> locations;

    public ProvidedLocation getProvidedLocation() {
        return providedLocation;
    }

    public void setProvidedLocation(ProvidedLocation providedLocation) {
        this.providedLocation = providedLocation;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Result{" +
                "providedLocation=" + providedLocation +
                ", locations=" + locations +
                '}';
    }
}

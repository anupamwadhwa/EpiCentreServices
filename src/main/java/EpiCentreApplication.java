import MapsAPIs.Geocoder;
import MapsAPIs.data.Coordinates;
import Services.HospitalLogin;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EpiCentreApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        Geocoder geocoder = new Geocoder();
        Coordinates result = geocoder.geocode("4-D Villa, Khasa Kothi Circle, Station Rd, Kanti Nagar, Bani Park, Jaipur, Rajasthan 302001");
        new EpiCentreApplication().run(args);

    }

    @Override
    public void run(Configuration epiCentre, Environment environment){
        final HospitalLogin hospitalLogin = new HospitalLogin();
        environment.jersey().register(hospitalLogin);
    }


    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new MultiPartBundle());
    }

}

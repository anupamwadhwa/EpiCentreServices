import Services.HospitalLogin;
import Services.IngestDetails;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EpiCentreApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new EpiCentreApplication().run(args);

    }

    @Override
    public void run(Configuration epiCentre, Environment environment){
        final HospitalLogin hospitalLogin = new HospitalLogin();
        environment.jersey().register(hospitalLogin);

        final IngestDetails ingestDetails = new IngestDetails();
        environment.jersey().register(ingestDetails);
    }


    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new MultiPartBundle());
    }

}

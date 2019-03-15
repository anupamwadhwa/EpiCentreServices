import Services.HospitalLogin;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class EpiCentreApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new EpiCentreApplication().run(args);

    }

    @Override
    public void run(Configuration epiCentre, Environment environment){
        final HospitalLogin hospitalLogin = new HospitalLogin();
        environment.jersey().register(hospitalLogin);
    }

}

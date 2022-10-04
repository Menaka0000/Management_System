package bo;

import bo.custom.impl.NewProgrammeBOImpl;
import bo.custom.impl.NewRegistrationBOImpl;
import bo.custom.impl.RegistrationBOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case NEW_PROGRAMME:
                return new NewProgrammeBOImpl();
            case NEW_REGISTRATION:
                return new NewRegistrationBOImpl();
            case REGISTRATIONS:
                return new RegistrationBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        NEW_PROGRAMME, NEW_REGISTRATION, REGISTRATIONS
    }

}

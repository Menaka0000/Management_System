package dao;

import dao.custom.impl.NewProgrammeDAOImpl;
import dao.custom.impl.NewRegistrationDAOImpl;
import dao.custom.impl.RegistrationDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case NEW_PROGRAMME:
                return new NewProgrammeDAOImpl();
            case NEW_REGISTRATION:
                return new NewRegistrationDAOImpl();
            case REGISTRATIONS:
                return new RegistrationDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        NEW_PROGRAMME, NEW_REGISTRATION, REGISTRATIONS
    }
}

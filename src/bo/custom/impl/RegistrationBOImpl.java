package bo.custom.impl;

import bo.custom.RegistrationsBO;
import dao.DAOFactory;
import dao.custom.RegistrationsDAO;
import entity.Student;

import java.util.List;

public class RegistrationBOImpl implements RegistrationsBO {
    private final RegistrationsDAO registrationsDAO = (RegistrationsDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTRATIONS);

    @Override
    public List<Student> getRegisteredStu(String id) {
        return registrationsDAO.getRegisteredStu(id);
    }
}

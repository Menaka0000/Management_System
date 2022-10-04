package bo.custom.impl;

import bo.custom.NewRegistrationBO;
import dao.DAOFactory;
import dao.custom.NewRegistrationDAO;
import dto.NewRegistrationDTO;
import entity.Programme;
import entity.Student;

import java.util.List;

public class NewRegistrationBOImpl implements NewRegistrationBO {
    private final NewRegistrationDAO newRegistrationDAO = (NewRegistrationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.NEW_REGISTRATION);


    @Override
    public List<String> getProgrammes() {
        return newRegistrationDAO.getAllProgrammes();
    }

    @Override
    public boolean newRegistration(NewRegistrationDTO nReDTO) {
        newRegistrationDAO.newRegistration(nReDTO);
        return true;
    }

    @Override
    public boolean newReForExistingStu(NewRegistrationDTO nReDTO) {
        newRegistrationDAO.newReForExistingStu(nReDTO);
        return true;
    }

    @Override
    public Programme getProgramme(String name) {
        List<Programme> programmeList = newRegistrationDAO.getProgramme(name);
        Programme programme = null;
        for (Programme pro :
                programmeList) {
            programme = pro;
        }
        return programme;
    }

    public List<Programme> getRegisteredPro(String id) {
        return newRegistrationDAO.getRegisteredPro(id);
    }

    @Override
    public Student getStudentDetail(String id) {
        return newRegistrationDAO.getStudentDetail(id);
    }
}

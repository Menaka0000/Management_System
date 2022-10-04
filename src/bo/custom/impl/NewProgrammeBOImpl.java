package bo.custom.impl;

import bo.custom.NewProgrammeBO;
import dao.DAOFactory;
import dao.custom.NewProgrammeDAO;
import dto.ProgrammeDTO;

public class NewProgrammeBOImpl implements NewProgrammeBO {

    private final NewProgrammeDAO newProgrammeDAO = (NewProgrammeDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.NEW_PROGRAMME);

    @Override
    public boolean saveProgramme(ProgrammeDTO programmeDTO) {
        return newProgrammeDAO.save(programmeDTO);
    }
}

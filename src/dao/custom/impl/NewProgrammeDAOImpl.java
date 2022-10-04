package dao.custom.impl;

import dao.custom.NewProgrammeDAO;
import dto.ProgrammeDTO;
import entity.Programme;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class NewProgrammeDAOImpl implements NewProgrammeDAO {

    @Override
    public boolean save(ProgrammeDTO pDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Programme(pDTO.getId(), pDTO.getName(), pDTO.getDuration(), pDTO.getFee(), pDTO.getStudentList()));
        transaction.commit();
        session.close();
        return true;
    }
}

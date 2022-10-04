package dao.custom;

import dao.SuperDAO;
import dto.ProgrammeDTO;

public interface NewProgrammeDAO extends SuperDAO {
     boolean save(ProgrammeDTO programmeDTO);
}

package bo.custom;

import bo.SuperBO;
import dto.ProgrammeDTO;

public interface NewProgrammeBO extends SuperBO {
     boolean saveProgramme(ProgrammeDTO programmeDTO);
}

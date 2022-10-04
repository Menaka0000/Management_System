package dao.custom;

import dao.SuperDAO;
import dto.NewRegistrationDTO;
import entity.Programme;
import entity.Student;

import java.util.List;

public interface NewRegistrationDAO  extends SuperDAO {
    List<String> getAllProgrammes();
    boolean newRegistration(NewRegistrationDTO nReDTO);
    boolean newReForExistingStu(NewRegistrationDTO nReDTO);
    Student getStudentDetail(String id);

    List<Programme> getProgramme(String name);
    List<Programme> getRegisteredPro(String id);
}

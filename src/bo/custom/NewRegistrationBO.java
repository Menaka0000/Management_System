package bo.custom;

import bo.SuperBO;
import dto.NewRegistrationDTO;
import entity.Programme;
import entity.Student;
import java.util.List;

public interface NewRegistrationBO extends SuperBO {
    List<String> getProgrammes();

    boolean newRegistration(NewRegistrationDTO nReDTO);

    boolean newReForExistingStu(NewRegistrationDTO nReDTO);

    Programme getProgramme(String name);

    List<Programme> getRegisteredPro(String id);

    Student getStudentDetail(String id);
}









